package com.yen.SpringSearchTwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("message", "hello from the controller !!!");
        return "resultPage";
    }

    @RequestMapping("/username/")
    public String hello2(@RequestParam("name") String userName, Model model){
        model.addAttribute("message", "hello,  " + userName);
        return "resultPage";
    }
}
