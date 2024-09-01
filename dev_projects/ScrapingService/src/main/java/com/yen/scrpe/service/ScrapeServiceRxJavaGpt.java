package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import reactor.core.publisher.Flux;

//import javax.lang.model.util.Elements;

public class ScrapeServiceRxJavaGpt implements BaseScrapeService {

  private final String BASE_URL = "https://scrapeme.live/shop";

  public ScrapeServiceRxJavaGpt() {}

  @Override
  public void scrapeProductPage(
      List<PokemonProduct> pokemonProducts,
      Set<String> pagesDiscovered,
      List<String> pagesToScrape,
      Integer i)
      throws IOException, InterruptedException {}

  private Single<Document> prepareConnect(int pageNum) {

    // V1
    //        return Single.fromCallable(() -> {
    //            String URL = this.BASE_URL + "/page/" + pageNum;
    //            System.out.println("URL = " + URL);
    //            return Jsoup.connect(URL)
    //                    .userAgent(
    //                            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
    // (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
    //                    .header("Accept-Language", "*")
    //                    .get();
    //        });

    // V2
    return Single.fromCallable(
       // Callable: https://blog.csdn.net/u010784887/article/details/79320856
        new Callable<Document>() {
          @Override
          public Document call() throws Exception {
            String BASE_URL = "https://scrapeme.live/shop";
            String URL = BASE_URL + "/page/" + pageNum;
            System.out.println("URL = " + URL);
            return Jsoup.connect(URL)
                .userAgent(
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
          }
        });
  }

    private Single<List<String>> collectToScrape(
            Elements paginationElements, List<String> pagesToScrape, Set<String> pagesDiscovered) {

        @NonNull Observable<List<String>> x = Observable.fromIterable(paginationElements)
                .map(pageElement -> {
                    String pageUrl = pageElement.attr("href");

                    // Add new page URLs to the pagesToScrape list if not already discovered
                    if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                        pagesToScrape.add(pageUrl);
                    }

                    // Add the page to the discovered pages
                    pagesDiscovered.add(pageUrl);
                    return pagesToScrape;
                });

        /** via singleOrError, can transform
         *  Observable<List<String>> to Single<List<String>>
         */
        return x.singleOrError();
    }



}
