package com.yen.tweet.controller;

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
public class TweetController {
    @RequestMapping("/test3")
    public String hello(Model model){
        model.addAttribute("message", "hello from the controller !!!");
        return "resultPage";
    }

    @Autowired
    private Twitter twitterImpl;

    @RequestMapping("/twitter")
    public String helloTwitter(@RequestParam(defaultValue = "ETF") String search, Model model){
        SearchResults searchResults = twitterImpl.searchOperations().search(search);
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
        return "resultPage";
    }
}
