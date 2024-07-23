package com.yen.scrpe;

import com.yen.scrpe.Task.PokemonCollectTask;
import com.yen.scrpe.Task.Factory.ScrapeTaskFactory;
import com.yen.scrpe.service.ScrapeService;

import java.io.IOException;

/**
 * // https://www.zenrows.com/blog/web-scraping-java#java-web-crawling // data source :
 * https://scrapeme.live/shop/
 */
public class ScrappingApplication {

  public static void main(String[] args) throws IOException, InterruptedException {

    Long start = System.currentTimeMillis();

    // to limit the number to scrape to 5
    int LIMIT = 10; // 50;

    /** V1 : single thread (original code ) */
    ScrapeService scrapeService = new ScrapeService();
    PokemonCollectTask pokemonCollectTask = new PokemonCollectTask(scrapeService);
    //pokemonCollectTask.run(LIMIT);

    ScrapeTaskFactory scrapeTaskFactory = new ScrapeTaskFactory(scrapeService, pokemonCollectTask, LIMIT);
    scrapeTaskFactory.run();


      /** V2 : multi thread (gpt) */
//      ScrapeServiceMultiThreadV2Gpt scrapeService = new ScrapeServiceMultiThreadV2Gpt();
//      PokemonCollectTask pokemonCollectTask = new PokemonCollectTask(scrapeService);
////      pokemonCollectTask.run(LIMIT);
//
//      ScrapeTaskFactory2 scrapeTaskFactory = new ScrapeTaskFactory2(scrapeService, pokemonCollectTask, LIMIT);
//      scrapeTaskFactory.run();





    // ScrapeServiceMultiThread scrapeServiceMultiThread = new
    // ScrapeServiceMultiThread();
    //            scrapeServiceMultiThread.testRun();

    //        System.out.println("pokemonProducts.size() = " +
    // pokemonCollectTask.getPokemonProducts().size());
    //        System.out.println("pokemonProducts = " + pokemonCollectTask.getPokemonProducts());

    Long end = System.currentTimeMillis();
    System.out.println("-----> Total duration = " + (end - start));
  }
}
