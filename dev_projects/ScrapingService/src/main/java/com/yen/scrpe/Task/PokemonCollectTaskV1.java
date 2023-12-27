package com.yen.scrpe.Task;

import com.yen.scrpe.model.PokemonProduct;
import com.yen.scrpe.service.BaseScrapeService;
import com.yen.scrpe.service.ScrapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonCollectTaskV1 {

    public void run(BaseScrapeService scrapeService, List<String> pagesToScrape, List<PokemonProduct> pokemonProducts, Set<String> pagesDiscovered, int limit) throws IOException {

        int i  = 0;

        while (!pagesToScrape.isEmpty() && i < limit) {
            System.out.println(">>> i = " + i);

            /** help func*/
            scrapeService.scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, i);

            // incrementing the iteration number
            i++;
        }
    }

}
