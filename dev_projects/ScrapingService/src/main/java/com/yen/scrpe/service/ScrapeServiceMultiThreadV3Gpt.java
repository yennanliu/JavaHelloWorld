package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ScrapeServiceMultiThreadV3Gpt implements BaseScrapeService {

    // attr
    private final String BASE_URL = "https://scrapeme.live/shop";
    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Thread pool with 10 threads

    // constructor
    public ScrapeServiceMultiThreadV3Gpt() {}

    // method
    public void scrapeProductPage(
            List<PokemonProduct> pokemonProducts,
            Set<String> pagesDiscovered,
            List<String> pagesToScrape,
            Integer limit) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(pagesToScrape.size());

        while (!pagesToScrape.isEmpty()) {
            String url = pagesToScrape.remove(0);
            executorService.submit(() -> {
                try {
                    scrapePage(url, pokemonProducts, pagesDiscovered, pagesToScrape);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        // Wait for all tasks to complete
        latch.await();
        shutdown();
    }

    private void scrapePage(String url, List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, List<String> pagesToScrape) throws IOException {
        pagesDiscovered.add(url);
        Document doc = this.prepareConnect(url);

        Elements paginationElements = doc.select("a.page-numbers");
        Elements products = doc.select("li.product");

        synchronized (pagesToScrape) {
            pagesToScrape.addAll(this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered));
        }

        synchronized (pokemonProducts) {
            pokemonProducts.addAll(this.collectProductData(products, pokemonProducts));
        }
    }

    private Document prepareConnect(String url) throws IOException {
        System.out.println("URL = " + url);
        return Jsoup.connect(url)
                .userAgent(
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
    }

    private List<String> collectToScrape(
            Elements paginationElements, List<String> pagesToScrape, Set<String> pagesDiscovered) {

        for (Element pageElement : paginationElements) {
            String pageUrl = pageElement.attr("href");

            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            pagesDiscovered.add(pageUrl);
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

    private void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}