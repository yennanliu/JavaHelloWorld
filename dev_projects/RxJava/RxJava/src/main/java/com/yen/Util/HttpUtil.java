package com.yen.Util;

/**
 *  Util call https://scrapeme.live/shop/page/2/
 *
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;


public class HttpUtil {

    private String BASE_URL = "https://scrapeme.live/shop/";

    public static String getHttpResponse(String url) throws Exception {
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Build HTTP Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // GET method
                .build();

        // Send request and get response (synchronous/blocking)
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the body of the response
        return response.body();
    }

}
