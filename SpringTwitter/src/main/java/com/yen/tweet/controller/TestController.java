package com.yen.tweet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("/test1")
    public String hello(Model model){
        model.addAttribute("message", "hello from the controller !!!");
        return "testPage";
    }

    @RequestMapping("/test2")
    public String hello2(Model model){
        model.addAttribute("message", "hello  2 from the controller !!!");
        return "testPage";
    }
}
