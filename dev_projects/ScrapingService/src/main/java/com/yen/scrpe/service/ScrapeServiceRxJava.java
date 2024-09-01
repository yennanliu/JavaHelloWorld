package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ScrapeServiceRxJava implements BaseScrapeService{

    // attr
    private final String BASE_URL = "https://scrapeme.live/shop";

    // constructor
    public ScrapeServiceRxJava() {}

    @Override
    public void scrapeProductPage(List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, List<String> pagesToScrape, Integer i) throws IOException, InterruptedException {

    }


    private Document prepareConnect(int pageNum) throws IOException {

        String URL = this.BASE_URL + "/page/" + pageNum;
        System.out.println("URL = " + URL);
        return Jsoup.connect(URL)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
    }

    private Flux<String> collectToScrape(
            Elements paginationElements, Flux<String> pagesToScrape, Set<String> pagesDiscovered) {

        List<String> toScrapeList = pagesToScrape.toStream().collect(Collectors.toList());

        // iterating over the pagination HTML elements
        for (Element pageElement : paginationElements) {

            // System.out.println(">>> pageElement = " + pageElement.text());
            // the new link discovered
            String pageUrl = pageElement.attr("href");

            // if the web page discovered is new and should be scraped
//            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
//                pagesToScrape.add(pageUrl);
//            }

            if (!pagesDiscovered.contains(pageUrl) && !toScrapeList.contains(pageUrl)) {
                //pagesToScrape.add(pageUrl);
                toScrapeList.add(pageUrl);
            }


            // adding the link just discovered
            // to the set of pages discovered so far
            pagesDiscovered.add(pageUrl);
        }

//        Flux.just(toScrapeList.stream().flatMap(x -> {
//            return x.;
//        }).collect(Collectors.toList());


        /** NOTE !!! vai Flux.fromIterable,
         *
         *  we can transform List<String> to Flux<String>
         */
        pagesToScrape = Flux.fromIterable(toScrapeList);

        return pagesToScrape;
    }

    private Flux<PokemonProduct> collectProductData(
            Elements products, List<PokemonProduct> pokemonProducts) {

        for (Element product : products) {
            PokemonProduct pokemonProduct = this.enrichProduct(product);
            pokemonProducts.add(pokemonProduct);
        }

        return Flux.fromIterable(pokemonProducts);
    }

    private PokemonProduct enrichProduct(Element product) {

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
