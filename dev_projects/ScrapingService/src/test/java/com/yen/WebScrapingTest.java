package com.yen;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        while ((inputLine = in.readLine()) != null) {
            System.out.println("inputLine = " + inputLine);
            response.append(inputLine);
        }

        System.out.println("BufferedReader close");
        in.close();
        String html = response.toString();
        System.out.println("html = " + html);

        // parse HTML (select "a[href]" element)
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String href = link.attr("href");
            System.out.println("href = " + href);
        }

        // save to csv
        System.out.println("save to csv");
        Writer writer = Files.newBufferedWriter(Paths.get("links.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
    }

}
