package com.yen.scrpe.Task.Factory;

import com.yen.scrpe.Task.PokemonCollectTask;
import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.ScrapeServiceMultiThreadV2Gpt;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ScrapeTaskFactory2 {

    private final ScrapeServiceMultiThreadV2Gpt scrapeService;
    private final PokemonCollectTask pokemonCollectTask;
    private final int limit;

    public ScrapeTaskFactory2(ScrapeServiceMultiThreadV2Gpt scrapeService, PokemonCollectTask pokemonCollectTask, int limit) {
        this.scrapeService = scrapeService;
        this.pokemonCollectTask = pokemonCollectTask;
        this.limit = limit;
    }

    public void run() throws IOException, InterruptedException {
        List<PokemonProduct> pokemonProducts = new LinkedList<>();
        Set<String> pagesDiscovered = new HashSet<>();
        List<String> pagesToScrape = new LinkedList<>();
        pagesToScrape.add("https://scrapeme.live/shop");

        //pokemonCollectTask.run(pokemonProducts, pagesDiscovered, pagesToScrape, limit);
        pokemonCollectTask.run(limit);

        System.out.println("Scraping completed.");
        System.out.println("Collected Pokemon Products:");
        for (PokemonProduct product : pokemonProducts) {
            System.out.println(product);
        }

        // Ensure the executor service is shut down
        scrapeService.shutdown();
    }

}