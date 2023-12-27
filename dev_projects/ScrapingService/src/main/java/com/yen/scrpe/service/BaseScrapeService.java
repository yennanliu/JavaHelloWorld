package com.yen.scrpe.service;

import com.yen.scrpe.model.PokemonProduct;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BaseScrapeService {

    public void  scrapeProductPage(List<PokemonProduct> pokemonProducts,
                                       Set<String> pagesDiscovered,
                                       List<String> pagesToScrape,
                                       Integer i) throws IOException;

}
