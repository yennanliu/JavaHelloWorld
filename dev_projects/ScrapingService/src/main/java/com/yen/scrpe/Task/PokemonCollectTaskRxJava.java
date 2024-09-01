package com.yen.scrpe.Task;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.BaseScrapeService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonCollectTaskRxJava implements BaseScrapeTask {

    // Attributes
    private BaseScrapeService scrapeService;
    private List<PokemonProduct> pokemonProducts;
    private Set<String> pagesDiscovered;
    private List<String> pagesToScrape;

    // Constructors
    public PokemonCollectTaskRxJava() {}

    public PokemonCollectTaskRxJava(BaseScrapeService scrapeService) {
        this.scrapeService = scrapeService;
        this.pokemonProducts = new ArrayList<>();
        this.pagesDiscovered = new HashSet<>();
        this.pagesToScrape = new ArrayList<>();

        // Initialize the scraping queue
        this.pagesToScrape.add("https://scrapeme.live/shop/page/1/");
        this.pagesToScrape.add("https://scrapeme.live/shop/page/2/");
        this.pagesToScrape.add("https://scrapeme.live/shop/page/50/");
    }

    // Getter and Setter methods
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

    // Method
    public void run(int limit) {
        Observable.fromIterable(pagesToScrape)
                .take(limit)
                .flatMap(pageUrl -> scrapePage(pageUrl)
                        .subscribeOn(Schedulers.io())
                        .doOnNext(product -> pagesDiscovered.add(pageUrl)))
                .toList();
        //return null;
    }

    private Observable<PokemonProduct> scrapePage(String pageUrl) {
        return Observable.create(emitter -> {
            try {
                scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, pagesToScrape.indexOf(pageUrl));
                pokemonProducts.forEach(emitter::onNext);
                emitter.onComplete();
            } catch (IOException e) {
                emitter.onError(e);
            }
        });
    }
}