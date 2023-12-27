package com.yen.scrpe;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.ScrapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  // https://www.zenrows.com/blog/web-scraping-java#java-web-crawling
 *  // scrape https://scrapeme.live/shop/
 *
 */
public class ScrappingApplication {

    public static void main(String[] args) throws IOException {

        ScrapeService scrapeService = new ScrapeService();

        System.out.println("ScrappingApplication start");

        Long start = System.currentTimeMillis();

        // initializing the list of Java object to store
        // the scraped data
        List<PokemonProduct> pokemonProducts = new ArrayList<>();

        // initializing the set of web page urls
        // discovered while crawling the target website
        Set<String> pagesDiscovered = new HashSet<>();

        // initializing the queue of urls to scrape
        List<String> pagesToScrape = new ArrayList<>();
        // initializing the scraping queue with the
        // first pagination page
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // the number of iteration executed
        int i = 0;
        // to limit the number to scrape to 5
        int limit = 50; //50;

        while (!pagesToScrape.isEmpty() && i < limit) {
            System.out.println(">>> i = " + i);

            /** help func*/
            scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, i);

            // incrementing the iteration number
            i++;
        }

        System.out.println("pokemonProducts.size() = " + pokemonProducts.size());

        // writing the scraped data to a db or export it to a file...

        Long end = System.currentTimeMillis();

        // limit = 5, -----> Total duration = 11344
        // limit = 50, -----> Total duration = 101870
        System.out.println("-----> Total duration = " + ( end - start));
    }

}