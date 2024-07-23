package com.yen.scrpe.Task;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.BaseScrapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonCollectTaskV3Gpt implements BaseScrapeTask {

    private BaseScrapeService scrapeService;
    private List<PokemonProduct> pokemonProducts;
    private Set<String> pagesDiscovered;
    private List<String> pagesToScrape;

    public PokemonCollectTaskV3Gpt(BaseScrapeService scrapeService) {
        this.scrapeService = scrapeService;
        this.pokemonProducts = new ArrayList<>();
        this.pagesDiscovered = new HashSet<>();
        this.pagesToScrape = new ArrayList<>();
        // Add initial pages to scrape
        this.pagesToScrape.add("https://scrapeme.live/shop/page/1/");
        this.pagesToScrape.add("https://scrapeme.live/shop/page/2/");
    }

    @Override
    public void run(int limit) throws IOException, InterruptedException {
        int i = 0;
        while (!this.pagesToScrape.isEmpty() && i < limit) {
            System.out.println(">>> i = " + i + ", thread name = " + Thread.currentThread().getName() + ", limit = " + limit);
            this.scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, i);
            i++;
        }
    }
}