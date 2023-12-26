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
import java.util.ArrayList;
import java.util.List;

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
    public void webScrapTest2(){

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

}
