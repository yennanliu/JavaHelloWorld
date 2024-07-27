package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeServiceMultiThreadV3Gpt implements BaseScrapeService {

  // attr
  private final String BASE_URL = "https://scrapeme.live/shop";

  private final int _pcautoSchedulerPoolSize = 1000;
  private static final int KEEP_ALIVE_TIME = 60;

  private static final int MAX_POOL_SIZE = 1000;
  private static final int CORE_POOL_SIZE = 500;

  // private final ExecutorService executorService = Executors.newFixedThreadPool(100); // Thread
  // pool with 10 threads

  private final ExecutorService executorService =
      new ThreadPoolExecutor(
          CORE_POOL_SIZE,
          MAX_POOL_SIZE,
          KEEP_ALIVE_TIME,
          TimeUnit.SECONDS,
          new SynchronousQueue<>(),
          new ThreadPoolExecutor.AbortPolicy() // DiscardPolicy
          );

  // constructor
  public ScrapeServiceMultiThreadV3Gpt() {}

  // method
  public void scrapeProductPage(
      List<PokemonProduct> pokemonProducts,
      Set<String> pagesDiscovered,
      List<String> pagesToScrape,
      Integer i)
      throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(pagesToScrape.size());

        System.out.println("scrapeProductPage run ... " + ", i = " + i + ", pagesToScrape = " + pagesToScrape);

        while (!pagesToScrape.isEmpty()) {
            String url = pagesToScrape.remove(0);
            Future<?> future = executorService.submit(() -> {
                try {
                    scrapePage(url, pokemonProducts, pagesDiscovered, pagesToScrape, i);
                    //scrapePage(limit, pokemonProducts, pagesDiscovered, pagesToScrape);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });

            if (future.isDone()){
                System.out.println(">>> (scrapeProductPage) future = " + future);
            }
        }

        // Wait for all tasks to complete
        latch.await(45, TimeUnit.SECONDS);
        shutdown();
    }

    private void scrapePage(String url, List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, List<String> pagesToScrape, Integer i) throws IOException {
      
        //String url2 = pagesToScrape.remove(0);
        String url2 = BASE_URL + "/" + i;
        if (!pagesDiscovered.contains(url2)){
            pagesDiscovered.add(url2);
        }

        Document doc = this.prepareConnect(i);

        Elements paginationElements = doc.select("a.page-numbers");
        Elements products = doc.select("li.product");

        synchronized (pagesToScrape) {
            System.out.println("(scrapePage) pagesToScrape");

            //pagesToScrape.addAll(this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered));
            List<String> urls = this.collectToScrape(paginationElements, pagesToScrape, pagesDiscovered);
            for (String url_ : urls){
                if(!pagesToScrape.contains(url_)){
                    pagesToScrape.add(url_);
                }
            }

            System.out.println(">>> (scrapePage) pagesToScrape = " + pagesToScrape);
            System.out.println(">>> (scrapePage) pagesDiscovered = " + pagesDiscovered);
        }

        synchronized (pokemonProducts) {
            System.out.println("(scrapePage) pokemonProducts");
            pokemonProducts.addAll(this.collectProductData(products, pokemonProducts));
            //System.out.println(">>> (scrapePage) pokemonProducts = " + pokemonProducts);
            System.out.println(">>> (scrapePage) pokemonProducts size = " + pokemonProducts.size());
        }
    }

    private Document prepareConnect(Integer i) throws IOException {
        String url = this.BASE_URL + "/page/" + i;
        System.out.println("url = " + url);
        System.out.println("i = " + i);
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
            System.out.println("---> (collectToScrape) pageUrl = " + pageUrl);

            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            System.out.println("--> (collectToScrape) pageUrl = " + pageUrl);
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
        //executorService.shutdown();
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