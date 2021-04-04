package com.yen.tweet.controller;

import com.yen.tweet.service.LightTweet;
import com.yen.tweet.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/search/{searchType}", method = RequestMethod.GET)
    public ModelAndView search(
            @PathVariable String searchType,
            @MatrixVariable List<String> keywords) {
        List<LightTweet> tweets = searchService.search(searchType, keywords);
        //ModelAndView modelAndView = new ModelAndView("resultPage");
        ModelAndView modelAndView = new ModelAndView("testPage");
        modelAndView.addObject("tweets", tweets);
        modelAndView.addObject("search", String.join(",", keywords));
        return modelAndView;
    }
}
