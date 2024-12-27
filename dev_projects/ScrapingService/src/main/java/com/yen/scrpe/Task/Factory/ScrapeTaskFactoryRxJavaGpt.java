package com.yen.scrpe.Task.Factory;

import com.yen.scrpe.Task.BaseScrapeTask;
import com.yen.scrpe.service.BaseScrapeService;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;

public class ScrapeTaskFactoryRxJavaGpt {

  // Attributes
  private BaseScrapeService scrapeService;
  private BaseScrapeTask scrapeTask;
  private int limit;

  public ScrapeTaskFactoryRxJavaGpt() {}

  public ScrapeTaskFactoryRxJavaGpt(
      BaseScrapeService scrapeService, BaseScrapeTask scrapeTask, Integer limit) {
    this.scrapeService = scrapeService;
    this.scrapeTask = scrapeTask;
    this.limit = limit;
  }

  // Methods
  public Single<Void> run() {
    return Single.create(
        emitter -> {
          try {
            scrapeTask.run(limit);
            emitter.onSuccess(null);
          } catch (IOException | InterruptedException e) {
            emitter.onError(e);
          }
        });
  }

}
