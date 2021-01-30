package com.yen.SpringSearchTwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@EnableSocial
@Controller
public class TwitterController {

    @Autowired
    private Twitter twitter;

    //    @RequestMapping("/twitter")
    //    public String helloTwitter(@RequestParam(defaultValue = "ETF") String search, Model model) {
    //        SearchResults searchResults = twitter.searchOperations().search(search);
    //        String text = searchResults.getTweets().get(0).getText();
    //        return "resultPage";
    //    }

    @RequestMapping("/twitter")
    public String helloTwitter(@RequestParam(defaultValue = "ETF") String search, Model model){
        SearchResults searchResults = twitter.searchOperations().search(search);
        String text = searchResults.getTweets().get(0).getText();
        return "resultPage";
    }
}
