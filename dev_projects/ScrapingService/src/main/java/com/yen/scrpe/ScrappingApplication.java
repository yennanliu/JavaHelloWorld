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

        Long start = System.currentTimeMillis();

        // to limit the number to scrape to 5
        int LIMIT = 3; //50;

        ScrapeService scrapeService = new ScrapeService();
        PokemonCollectTaskV1 pokemonCollectTaskV1 = new PokemonCollectTaskV1(scrapeService);
        pokemonCollectTaskV1.run(LIMIT);

        System.out.println("pokemonProducts.size() = " + pokemonCollectTaskV1.getPokemonProducts().size());
        System.out.println("pokemonProducts = " + pokemonCollectTaskV1.getPokemonProducts());

        Long end = System.currentTimeMillis();
        System.out.println("-----> Total duration = " + ( end - start));
    }

}