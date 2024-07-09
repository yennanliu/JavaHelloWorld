package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScrapeServiceMultiThreadV2Gpt implements BaseScrapeService {

    // attr
    private final String BASE_URL = "https://scrapeme.live/shop";
    static int THREAD_POOL_SIZE = 20;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE); // Thread pool with 10 threads

    // constructor
    public ScrapeServiceMultiThreadV2Gpt() {}

    // method
    public void scrapeProductPage(
            List<PokemonProduct> pokemonProducts,
            Set<String> pagesDiscovered,
            List<String> pagesToScrape,
            Integer i)
            throws IOException, InterruptedException {

        System.out.println(
                ">>> (scrapeProductPage) pagesDiscovered = "
                        + pagesDiscovered
                        + " pagesToScrape = "
                        + pagesToScrape);


        /** make sure main thread wait till all scrapping thread completed */
        CountDownLatch latch = new CountDownLatch(pagesToScrape.size());

        while (!pagesToScrape.isEmpty()) {
            String url = pagesToScrape.remove(0);
            executorService.submit(() -> {

                System.out.println("====> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());

                try {
                    scrapePage(url, pokemonProducts, pagesDiscovered, pagesToScrape, i);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    /** latch -= 1 */
                    latch.countDown();
                }
            });
        }

//        String url = pagesToScrape.remove(0);
//        executorService.submit(() -> {
//            try {
//                scrapePage(url, pokemonProducts, pagesDiscovered, pagesToScrape, i);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

        // Wait for all tasks to complete
        latch.await();

        // Shutdown the executor service once all tasks are submitted
        //executorService.shutdown();
    }

    private void scrapePage(String url, List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, List<String> pagesToScrape, Integer i) throws IOException {
        pagesDiscovered.add(url);
        Document doc = this.prepareConnect(i);

        Elements paginationElements = doc.select("a.page-numbers");
        Elements products = doc.select("li.product");

//        pagesToScrape = this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered);
//        pokemonProducts = this.collectProductData(products, pokemonProducts);

        synchronized (pagesToScrape) {
            System.out.println("synchronized (pagesToScrape) run ...");
            pagesToScrape = this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered);
        }

        synchronized (pokemonProducts) {
            System.out.println("synchronized (pokemonProducts) run ...");
            pokemonProducts = this.collectProductData(products, pokemonProducts);
        }

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

    private List<String> collectToScrape(
            Elements paginationElements, List<String> pagesToScrape, Set<String> pagesDiscovered) {

        for (Element pageElement : paginationElements) {

            //System.out.println("pageElement = " + pageElement);

            String pageUrl = pageElement.attr("href");

            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            pagesDiscovered.add(pageUrl);
            System.out.println("pagesDiscovered = " + pagesDiscovered);
            System.out.println("pagesToScrape = " + pagesToScrape);
        }
        return pagesToScrape;
    }

    private List<PokemonProduct> collectProductData(
            Elements products, List<PokemonProduct> pokemonProducts) {

        for (Element product : products) {
            PokemonProduct pokemonProduct = this.enrichProduct(product);
            pokemonProducts.add(pokemonProduct);
        }

        return pokemonProducts;
    }

    private PokemonProduct enrichProduct(Element product) {
        PokemonProduct pokemonProduct = new PokemonProduct();

        pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
        pokemonProduct.setImage(product.selectFirst("img").attr("src"));
        pokemonProduct.setName(product.selectFirst("h2").text());
        pokemonProduct.setPrice(product.selectFirst("span").text());

        return pokemonProduct;
    }

    public void shutdown() {
        executorService.shutdown();
    }

}