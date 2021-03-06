package com.yen.tweet.controller;

/**
 *  Backup of com.yen.tweet.controller.TweetController
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TweetControllerBackup {
    @RequestMapping("/test4")
    public String hello4(Model model){
        model.addAttribute("message", "hello from the controller !!!");
        //return "resultPage";
        return "testPage";
    }

    @Autowired
    private Twitter twitter;

    //endpoint : http://localhost:8080/twitter
    @RequestMapping("/twitter")
    public String helloTwitter(@RequestParam(defaultValue = "ETF") String search, Model model){
        SearchResults searchResults = twitter.searchOperations().search(search);
        System.out.println("searchResults = " + searchResults);

        List<String> tweets =
                searchResults.getTweets()
                        .stream()
                        .map(Tweet::getText)
                        .collect(Collectors.toList());
        //String tweets = searchResults.getTweets().get(0).getText();
        //String tweets = "etf !!!";

        System.out.println("tweets = " + tweets);
        model.addAttribute("tweets", tweets);
        //return "resultPage";
        return "testPage";
    }

    // endpoint : http://localhost:8080/api/v1/twitter/?search=<keyword>
    @RequestMapping("/api/v1")
    public String queryTwitter(@RequestParam(defaultValue = "ETF") String search, Model model){
        SearchResults searchResults = twitter.searchOperations().search(search);
        System.out.println("searchResults = " + searchResults);

        //        List<String> tweets =
        //                searchResults.getTweets()
        //                        .stream()
        //                        .map(Tweet::getText)
        //                        .collect(Collectors.toList());

        //        List<Tweet> tweets =
        //                searchResults.getTweets();

        List<String> tweets =
                searchResults.getTweets()
                        .stream()
                        .map(Tweet::getText)
                        .collect(Collectors.toList());

        model.addAttribute("tweets", tweets);
        model.addAttribute("search", search);

        System.out.println("tweets = " + tweets);
        System.out.println("search = " + search);

        return "resultPage2";
        //return "testPage";
    }
}
