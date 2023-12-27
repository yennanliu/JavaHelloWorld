package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ScrapeService {

    // attr
    public ScrapeService(){

    }

    // constructor
    private String BASE_URL = "https://scrapeme.live/shop";

    // method
    public void scrapeProductPage(List<PokemonProduct> pokemonProducts,
                                  Set<String> pagesDiscovered,
                                  List<String> pagesToScrape,
                                  Integer i) throws IOException {


        System.out.println(">>> (scrapeProductPage) pagesDiscovered = " + pagesDiscovered + " pagesToScrape = " + pagesToScrape);

        // the current web page is about to be scraped and
        // should no longer be part of the scraping queue
        String url = pagesToScrape.remove(0);
        pagesDiscovered.add(url);
        Document doc = this.prepareConnect(i);

        Elements paginationElements = doc.select("a.page-numbers");
        Elements products = doc.select("li.product");

        pagesToScrape = this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered);
        pokemonProducts = this.collectProductData(products, pokemonProducts);
    }

    private Document prepareConnect(int pageNum) throws IOException {

        // scraping logic omitted for brevity...
        // fetching the target website
        // doc = Jsoup.connect(URL).get();
        // initializing the HTML Document page variable
        Document doc;
        String URL = BASE_URL + "/page/" + pageNum;
        System.out.println("URL = " + URL);
        return Jsoup
                .connect(URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
    }

    private List<String> collectToScrape(Elements paginationElements, List<String> pagesToScrape, Set<String> pagesDiscovered) {

        // iterating over the pagination HTML elements
        for (Element pageElement : paginationElements) {

            //System.out.println(">>> pageElement = " + pageElement.text());
            // the new link discovered
            String pageUrl = pageElement.attr("href");

            // if the web page discovered is new and should be scraped
            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            // adding the link just discovered
            // to the set of pages discovered so far
            pagesDiscovered.add(pageUrl);
        }
        return pagesToScrape;
    }

    private List<PokemonProduct> collectProductData(Elements products, List<PokemonProduct> pokemonProducts){

        for (Element product : products){
            PokemonProduct pokemonProduct = this.enrichProduct(product);
            pokemonProducts.add(pokemonProduct);
        }

        return pokemonProducts;
    }

    private PokemonProduct enrichProduct(Element product){

        // collect data
        PokemonProduct pokemonProduct = new PokemonProduct();

        // extracting the data of interest from the product HTML element
        // and storing it in pokemonProduct
        pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
        pokemonProduct.setImage(product.selectFirst("img").attr("src"));
        pokemonProduct.setName(product.selectFirst("h2").text());
        pokemonProduct.setPrice(product.selectFirst("span").text());

        return pokemonProduct;
    }

}
