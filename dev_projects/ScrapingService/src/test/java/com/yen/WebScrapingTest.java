package com.yen;

import model.PokemonProduct;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebScrapingTest {

    @Test
    public void test(){
        System.out.println(123);
    }

    // https://nanonets.com/blog/java-web-scraping-tutorial/
    @Test
    public void webScrapTest1() throws IOException {

        String url = "https://www.example.com";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        // save to html/txt
        Writer writer = Files.newBufferedWriter(Paths.get("links.html"));

        while ((inputLine = in.readLine()) != null) {
            System.out.println("inputLine = " + inputLine);
            writer.append(inputLine);
            response.append(inputLine);
        }

        System.out.println("BufferedReader close");
        in.close();
        String html = response.toString();
        System.out.println("html = " + html);

        System.out.println("save to file");
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        writer.close();

        // parse HTML (select "a[href]" element)
//        Document doc = Jsoup.parse(html);
//        Elements links = doc.select("a[href]");
//        for (Element link : links) {
//            String href = link.attr("href");
//            System.out.println("href = " + href);
//        }

    }


    // https://www.zenrows.com/blog/web-scraping-java#connect-to-target-website
    @Test
    public void webScrapTestPokemonV1(){

        String URL = "https://scrapeme.live/shop";

        // initializing the HTML Document page variable
        Document doc;

        List<PokemonProduct> pokemonProducts = new ArrayList<>();

        try {
            // fetching the target website
            // doc = Jsoup.connect(URL).get();
            doc = Jsoup
                    .connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    .header("Accept-Language", "*")
                    .get();
            //System.out.println("doc = " + doc);

//            Elements products = doc.select("li.product");
//            System.out.println("products = " + products);

            // initializing the list of Java object to store
            // the scraped data
            //List<PokemonProduct> pokemonProducts = new ArrayList<>();

            // retrieving the list of product HTML elements
            Elements products = doc.select("li.product");

            // iterating over the list of HTML products
            for (Element product : products) {
                PokemonProduct pokemonProduct = new PokemonProduct();

                // extracting the data of interest from the product HTML element
                // and storing it in pokemonProduct
                pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
                pokemonProduct.setImage(product.selectFirst("img").attr("src"));
                pokemonProduct.setName(product.selectFirst("h2").text());
                pokemonProduct.setPrice(product.selectFirst("span").text());

                // adding pokemonProduct to the list of the scraped products
                pokemonProducts.add(pokemonProduct);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(">>> pokemonProducts = ");
        System.out.println(pokemonProducts.toString());

        String resultDir = "./scrap_data.json";

        // save to JSON
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(pokemonProducts.toString());
            //convert Object to JSONObject
            JSONArray jsonObject3 = (JSONArray) object;
            try {
                FileWriter file = new FileWriter(resultDir);
                file.write(jsonObject3.toString());
                file.close();
            } catch (IOException e) {
                System.out.println("write to JSON fail : " + e);
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // https://www.zenrows.com/blog/web-scraping-java#java-web-crawling
    // scrape https://scrapeme.live/shop/ with page limit
    @Test
    public void webScrapTestPokemonV2() throws IOException {

        // initializing the list of Java object to store
        // the scraped data
        List<PokemonProduct> pokemonProducts = new ArrayList<>();

        // initializing the set of web page urls
        // discovered while crawling the target website
        Set<String> pagesDiscovered = new HashSet<>();

        // initializing the queue of urls to scrape
        List<String> pagesToScrape = new ArrayList<>();
        // initializing the scraping queue with the
        // first pagination page
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // the number of iteration executed
        int i = 0;
        // to limit the number to scrape to 5
        int limit = 5; //48;

        while (!pagesToScrape.isEmpty() && i < limit) {
            System.out.println(">>> i = " + i);

            /** help func*/
            scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, i);

            // incrementing the iteration number
            i++;
        }

        System.out.println("pokemonProducts.size() = " + pokemonProducts.size());

        // writing the scraped data to a db or export it to a file...
    }

    private void scrapeProductPage(List<PokemonProduct> pokemonProducts,
                                   Set<String> pagesDiscovered,
                                   List<String> pagesToScrape,
                                   Integer i) throws IOException {


        System.out.println(">>> (scrapeProductPage) pagesDiscovered = " + pagesDiscovered + " pagesToScrape = " + pagesToScrape);

        // the current web page is about to be scraped and
        // should no longer be part of the scraping queue
        String url = pagesToScrape.remove(0);

        pagesDiscovered.add(url);

        // scraping logic omitted for brevity...
        // fetching the target website
        // doc = Jsoup.connect(URL).get();
        // initializing the HTML Document page variable
        Document doc;
        String URL = "https://scrapeme.live/shop"+"/page/" + i;
        System.out.println("URL = " + URL);
        doc = Jsoup
                .connect(URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .header("Accept-Language", "*")
                .get();
        Elements paginationElements = doc.select("a.page-numbers");

        // iterating over the pagination HTML elements
        for (Element pageElement : paginationElements) {

            //System.out.println(">>> pageElement = " + pageElement.text());

            // the new link discovered
            String pageUrl = pageElement.attr("href");

            // if the web page discovered is new and should be scraped
            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            // adding the link just discovered
            // to the set of pages discovered so far
            pagesDiscovered.add(pageUrl);
        }
    }


    // https://www.zenrows.com/blog/web-scraping-java#java-web-crawling
    // scrape https://scrapeme.live/shop/ with page limit and run in parallel
    @Test
    public void webScrapTestPokemonV2Parallel() throws Exception {

        // initializing the list of Java object to store
        // the scraped data
        List<PokemonProduct> pokemonProducts = Collections.synchronizedList(new ArrayList<>());

        // initializing the set of web page urls
        // discovered while crawling the target website
        Set<String> pagesDiscovered = Collections.synchronizedSet(new HashSet<>());

        // initializing the queue of urls to scrape
        List<String> pagesToScrape = Collections.synchronizedList(new ArrayList<>());
        // initializing the scraping queue with the
        // first pagination page
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // initializing the ExecutorService to run the
        // web scraping process in parallel on 4 pages at a time
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /** help func
         *
         *  // launching the web scraping process to discover some
         *  // urls and take advantage of the parallelization process
         */
        scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, 0);

        // the number of iteration executed
        int i = 1;
        // to limit the number to scrape to 5
        int limit = 48; //10;

        while (!pagesToScrape.isEmpty() && i < limit) {
            // registering the web scraping task
            int finalI = i;
            executorService.execute(() -> {
                try {
                    scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape, finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            // adding a 200ms delay to avoid overloading the server
            TimeUnit.MILLISECONDS.sleep(200);

            // incrementing the iteration number
            i++;
        }

        // waiting up to 300 seconds for all pending tasks to end
        executorService.shutdown();
        executorService.awaitTermination(300, TimeUnit.SECONDS);

        System.out.println(pokemonProducts.size());
    }

//    public static void scrapeProductPage(
//            List<PokemonProduct> pokemonProducts,
//            Set<String> pagesDiscovered,
//            List<String> pagesToScrape
//    ) {
//        // omitted for brevity...
//    }



}
