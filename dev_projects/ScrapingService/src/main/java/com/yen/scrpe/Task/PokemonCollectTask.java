package com.yen.scrpe.Task;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.BaseScrapeService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonCollectTask implements BaseScrapeTask {

  // attr
  // int limit;

  private BaseScrapeService scrapeService;
  // initializing the list of Java object to store
  // the scraped data
  private List<PokemonProduct> pokemonProducts;
  // initializing the set of web page urls
  private Set<String> pagesDiscovered; // discovered while crawling the target website
  // initializing the queue of urls to scrape
  private List<String> pagesToScrape;

  // constructor
  // PokemonCollectTaskV1.run(scrapeService, pagesToScrape, pokemonProducts, pagesDiscovered,
  // LIMIT);
  public PokemonCollectTask() {}

  public PokemonCollectTask(BaseScrapeService scrapeService) {

    this.scrapeService = scrapeService;
    this.pokemonProducts = new ArrayList<>();
    this.pagesDiscovered = new HashSet<>();
    this.pagesToScrape = new ArrayList<>();

    // initializing the scraping queue
    this.pagesToScrape.add("https://scrapeme.live/shop/page/1/");
    this.pagesToScrape.add("https://scrapeme.live/shop/page/2/");
    this.pagesToScrape.add("https://scrapeme.live/shop/page/50/");
  }

  // getter, setter
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

  // method
  // TODO : check synchronized implement on run method
  public void run(int limit) throws IOException, InterruptedException {

    int i = 0;

    while (!this.pagesToScrape.isEmpty() && i < limit) {
      System.out.println(">>> i = " + i  + ", thread name = " + Thread.currentThread().getName());

      /** help func */
      this.scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, i);

      // incrementing the iteration number
      i++;
    }
  }

}
