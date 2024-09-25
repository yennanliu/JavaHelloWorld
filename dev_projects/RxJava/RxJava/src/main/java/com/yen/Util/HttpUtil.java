package com.yen.Util;

/**
 *  Util call https://scrapeme.live/shop/page/2/
 *
 */

import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class HttpUtil {

    private String BASE_URL = "https://scrapeme.live/shop/";

    //private String BASE_PAGE_URL = "https://scrapeme.live/shop/page";

    List<String> collectedUrl = new ArrayList<>();

    public static String getHttpResponse(String url) throws Exception {
        // Create HttpClient
        //HttpClient client = HttpClient.newHttpClient();

        // Build HTTP Request
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET() // GET method
//                .build();

        // Send request and get response (synchronous/blocking)
        HttpResponse<String> response = getHttpClient().send(createHttpRequest(url), HttpResponse.BodyHandlers.ofString());

        // Return the body of the response
        return filterHrefContent(response.body());
        //return response.body();
    }

    public List<String> getHttpResponseRecursive(String url) throws Exception {

        System.out.println(">>> url = " + url);
        HttpResponse<String> response = getHttpClient().send(createHttpRequest(url), HttpResponse.BodyHandlers.ofString());
        if (response != null && response.body() != null && response.body().contains(BASE_URL + "/page")){

            String res = filterHrefContent(response.body());

            for (String _url: res.split("\n")){
                if(this.collectedUrl.contains(_url)){
                    continue;
                }
                this.collectedUrl.add(_url);
                // recursive call
                getHttpResponseRecursive(_url);
            }
            //return filterHrefContent(response.body());
        }

        System.out.println("final collected URL count = " + this.collectedUrl.size());
        return this.collectedUrl;
    }

    public Flux<String> getHttpResponseRecursiveRX(String url) throws Exception{

        System.out.println(">>> url = " + url);

        Single<String> x = Single.fromCallable(
                        () -> {

                            HttpResponse<String> response =
                                    getHttpClient().send(createHttpRequest(url), HttpResponse.BodyHandlers.ofString());

                            return response.body();
                        })
                .timeout(5, TimeUnit.SECONDS)
                .onErrorReturn(throwable -> "Error occurred: " + throwable.getMessage());

        return null;
    }

    public static Single<String> getHttpResponseRX(String url) throws Exception{
    // TODO : check why Single.fromCallable
    /**
     *     @CheckReturnValue
     *     @SchedulerSupport("none")
     *     public static <@NonNull T> @NonNull Single<T> fromCallable(@NonNull Callable<? extends T> callable) {
     *         Objects.requireNonNull(callable, "callable is null");
     *         return RxJavaPlugins.onAssembly(new SingleFromCallable(callable));
     *     }
     *
     *
     *
     *   Difference Between Single.fromCallable() and Single.just()
     *
     * 	•	Single.just():
     * 	    •	Immediately emits the result when created. It’s used when you already have the data available at the time of creating the Single.
     * 	    •	If any exception occurs during the creation of the data, it will not handle it properly (it will throw the exception during creation, not during subscription).
     *
     * 	•	Single.fromCallable():
     * 	    •	Defer execution until the Single is subscribed to.
     * 	    •	Captures exceptions thrown during the task and forwards them as onError events, making it safer for potentially error-prone operations like IO or database access.
     *
     *
     *  Key Reasons to Use Single.fromCallable():
     *
     * 	1.	Defer Execution Until Subscription:
     * 	    •	Single.fromCallable() defers the execution of the provided Callable until someone subscribes to the Single. This means the task is not performed immediately, but only when a subscriber requests it.
     * 	    •	This is useful when you want to delay an operation until the data is needed (lazy evaluation).
     * 	2.	Thread Management:
     * 	    •	With Single.fromCallable(), you can easily execute the task on different schedulers (like IO, computation, etc.) without manually managing threads. For example, you can move blocking IO operations to a background thread with RxJava schedulers.
     * 	    •	Example: .subscribeOn(Schedulers.io()) to handle an IO operation on a background thread.
     * 	3.	Error Handling:
     * 	    •	Single.fromCallable() makes error handling straightforward. If the Callable throws an exception, it automatically propagates that error downstream to the onError handler.
     * 	    •	You don’t need to wrap the code in try-catch blocks; any exception inside the Callable is treated as an error event.
     * 	4.	Avoid Blocking the Main Thread:
     * 	    •	When used with schedulers, you can offload blocking operations (e.g., database or network calls) to background threads, making it ideal for UI or other non-blocking contexts.
     * 	5.	Converting Synchronous Code to Reactive Streams:
     * 	    •	You can use Single.fromCallable() to adapt existing synchronous code (e.g., fetching data from a database, reading files) into a reactive, non-blocking flow without changing the original logic much.
     *
     *
     *
     *  Summary of When to Use Single.fromCallable():
     *
     * 	    •	When you have blocking operations (e.g., IO, file reading, database access) that should be executed asynchronously.
     * 	    •	When you want to handle exceptions and errors in a reactive flow.
     * 	    •	When the task should be deferred until subscription.
     * 	    •	When integrating synchronous code into a reactive system.
     */
    return Single.fromCallable(
            () -> {

              HttpResponse<String> response =
                      getHttpClient().send(createHttpRequest(url), HttpResponse.BodyHandlers.ofString());

              return response.body();
            })
        .timeout(5, TimeUnit.SECONDS)
        .onErrorReturn(throwable -> "Error occurred: " + throwable.getMessage());

        // TODO : check if use onErrorResumeNext or onErrorReturn .. for code above
    }

    private static HttpClient getHttpClient(){
        return HttpClient.newHttpClient();
    }

    private static HttpRequest createHttpRequest(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // GET method
                .build();
    }

    private static String filterHrefContent(String responseBody) {

        //System.out.println(">>> responseBody = " + responseBody);

        // Regular expression to find href="..."
        //Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"");
        //Pattern hrefPattern = Pattern.compile("href=\"(https://scrapeme\\.live/shop/page/\\d+/)\"");
        Pattern hrefPattern = Pattern.compile("href=['\"](https://scrapeme\\.live/shop/page/\\d+/)['\"]");
        Matcher matcher = hrefPattern.matcher(responseBody);

        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            // Append only the href content
            //sb.append(matcher.group()).append("\n");
            sb.append(matcher.group(1)).append("\n"); // remove no need item from filter result, e.g.  get https://scrapeme.live/shop/page/1/ from href="https://scrapeme.live/shop/page/1/"
        }

        //System.out.println("size = " + sb.toString().split("\n").length);
        return sb.toString();
    }

}
