package com.yen.scrpe.Task;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.BaseScrapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class PokemonCollectTaskV3Gpt implements BaseScrapeTask {

    private BaseScrapeService scrapeService;
    private List<PokemonProduct> pokemonProducts;
    private Set<String> pagesDiscovered;
    private List<String> pagesToScrape;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Thread pool with 10 threads
    private final CountDownLatch latch;

    public PokemonCollectTaskV3Gpt(BaseScrapeService scrapeService) {
        this.scrapeService = scrapeService;
        this.pokemonProducts = new ArrayList<>();
        this.pagesDiscovered = new HashSet<>();
        this.pagesToScrape = new ArrayList<>();
        this.latch = new CountDownLatch(1); // Initialize with 1 to wait for completion
        initializePages();
    }

    private void initializePages() {
        this.pagesToScrape.add("https://scrapeme.live/shop/page/1/");
        this.pagesToScrape.add("https://scrapeme.live/shop/page/2/");
        this.pagesToScrape.add("https://scrapeme.live/shop/page/50/");
    }

    public BaseScrapeService getScrapeService() {
        return scrapeService;
    }

    public void setScrapeService(BaseScrapeService scrapeService) {
        this.scrapeService = scrapeService;
    }

    public List<PokemonProduct> getPokemonProducts() {
        return pokemonProducts;
    }

    public void setPokemonProducts(List<PokemonProduct> pokemonProducts) {
        this.pokemonProducts = pokemonProducts;
    }

    public Set<String> getPagesDiscovered() {
        return pagesDiscovered;
    }

    public void setPagesDiscovered(Set<String> pagesDiscovered) {
        this.pagesDiscovered = pagesDiscovered;
    }

    public List<String> getPagesToScrape() {
        return pagesToScrape;
    }

    public void setPagesToScrape(List<String> pagesToScrape) {
        this.pagesToScrape = pagesToScrape;
    }

    public void run(int limit) throws IOException, InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        int i = 0;

        while (!this.pagesToScrape.isEmpty() && i < limit) {
            String url = this.pagesToScrape.remove(0);
            int finalI = i;
            futures.add(executorService.submit(() -> {
                try {
                    this.scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, List.of(url), finalI);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
            i++;
        }

        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // Blocking call to ensure completion
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        shutdown();
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