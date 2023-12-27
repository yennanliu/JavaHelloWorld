package com.yen.scrpe;

import com.yen.scrpe.Task.PokemonCollectTaskV1;
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

        System.out.println("ScrappingApplication start");
        Long start = System.currentTimeMillis();

        ScrapeService scrapeService = new ScrapeService();
        PokemonCollectTaskV1 pokemonCollectTaskV1 = new PokemonCollectTaskV1();

        // initializing the list of Java object to store
        // the scraped data
        List<PokemonProduct> pokemonProducts = new ArrayList<>();
        // initializing the set of web page urls
        Set<String> pagesDiscovered = new HashSet<>(); // discovered while crawling the target website
        // initializing the queue of urls to scrape
        List<String> pagesToScrape = new ArrayList<>();
        // initializing the scraping queue with the
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // to limit the number to scrape to 5
        int LIMIT = 3; //50;

        pokemonCollectTaskV1.run(scrapeService, pagesToScrape, pokemonProducts, pagesDiscovered, LIMIT);
        System.out.println("pokemonProducts.size() = " + pokemonProducts.size());

        Long end = System.currentTimeMillis();
        System.out.println("-----> Total duration = " + ( end - start));
    }

}