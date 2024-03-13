package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScrapeServiceMultiThread implements BaseScrapeService{

    private String BASE_URL = "https://scrapeme.live/shop";

    List<PokemonProduct> pokemonProducts;

    Set<String> pagesDiscovered;

    List<String> pagesToScrape;

    @Override
    public void scrapeProductPage(List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, List<String> pagesToScrape, Integer i) throws IOException {

        System.out.println("(scrapeProductPage) i =  " + i);

        String url = pagesToScrape.remove(0);
        pagesDiscovered.add(url);
        Document doc = this.prepareConnect(i);

        Elements paginationElements = doc.select("a.page-numbers");
        Elements products = doc.select("li.product");

        System.out.println("(scrapeProductPage) products = " + products);
    }

    private Document prepareConnect(int pageNum) throws IOException {

        // scraping logic omitted for brevity...
        // fetching the target website
        // doc = Jsoup.connect(URL).get();
        // initializing the HTML Document page variable
        String URL = this.BASE_URL + "/page/" + pageNum;
        System.out.println("URL = " + URL);
        return Jsoup
                .connect(URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
    }

    public void testRun() throws IOException, InterruptedException {

        Long start = System.currentTimeMillis();

        // initializing the list of Java object to store the scraped data
        pokemonProducts = Collections.synchronizedList(new ArrayList<>());

        // initializing the set of web page urls, discovered while crawling the target website
        pagesDiscovered = Collections.synchronizedSet(new HashSet<>());

        // initializing the queue of urls to scrape
        pagesToScrape = Collections.synchronizedList(new ArrayList<>());

        // initializing the scraping queue with the first pagination page
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // initializing the ExecutorService to run the web scraping process in parallel on 4 pages at a time
        int THREAD_COUNT = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        /** help func
         *
         *  // launching the web scraping process to discover some
         *  // urls and take advantage of the parallelization process
         */
        scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, 0);

        // the number of iteration executed
        int i = 1;
        // to limit the number to scrape to 5
        int limit = 50; //48; //10;

        while (!pagesToScrape.isEmpty() && i < limit) {
            // registering the web scraping task
            int finalI = i;
            System.out.println("(testRun) i = " + i);
            executorService.execute(() -> {
                try {
                    scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // adding a 200ms delay to avoid overloading the server
            TimeUnit.MILLISECONDS.sleep(200);

            // incrementing the iteration number
            i++;
        }

        // waiting up to 300 seconds for all pending tasks to end
        executorService.shutdown();
        executorService.awaitTermination(300, TimeUnit.SECONDS);

        System.out.println("pokemonProducts.size() = " + pokemonProducts.size());

        Long end = System.currentTimeMillis();

        // limit = 5, -----> Total duration = 5240
        // limit = 50, -----> Total duration = 27258
        System.out.println("-----> Total duration = " + ( end - start));
    }

}
