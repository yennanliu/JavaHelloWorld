package com.yen.SpringSearchTwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TwitterController {

    private final Twitter twitter;

    @Autowired
    public TwitterController(Twitter twitter) {
        this.twitter = twitter;
    }

    @RequestMapping(value = "timeline", method = RequestMethod.GET)
    public String getUserTimeline(@RequestParam("id") String screenName, Model model) {
        return "timeline";
    }


}