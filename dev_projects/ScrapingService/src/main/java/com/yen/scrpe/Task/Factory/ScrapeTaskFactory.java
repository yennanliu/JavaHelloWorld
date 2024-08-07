package com.yen.scrpe.Task.Factory;

import com.yen.scrpe.Task.BaseScrapeTask;
import com.yen.scrpe.service.BaseScrapeService;
import java.io.IOException;

/**
 * Factory for constructing scraping job
 *
 * <p>Design pattern : Factory
 *
 * <p>- https://www.runoob.com/design-pattern/factory-pattern.html
 */
public class ScrapeTaskFactory {

  // attr
  private BaseScrapeService scrapeService;

  private BaseScrapeTask scrapeTask;

  private String jobName;

  private int limit;

  // constructor
  public ScrapeTaskFactory() {}

  public ScrapeTaskFactory(
      BaseScrapeService scrapeService, BaseScrapeTask scrapeTask, Integer limit) {

    this.scrapeService = scrapeService;
    this.scrapeTask = scrapeTask;
    this.limit = limit;
  }

  // method
  public void run() throws IOException, InterruptedException {

    //    this.jobName = "PokemonCollectTask";
    //    System.out.println("this.jobName = " + this.jobName);

    this.scrapeTask.run(this.limit);

    //    switch (this.jobName) {
    //      case "PokemonCollectTask":
    //        // pokemonCollectTask.run(LIMIT);
    //        this.scrapeTask.run(this.limit);
    //      default:
    //        throw new RuntimeException("Not a valid task name :" + this.scrapeTask.toString());
    //    }
  }

}
