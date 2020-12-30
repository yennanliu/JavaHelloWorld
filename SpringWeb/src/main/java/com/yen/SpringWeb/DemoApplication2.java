package com.yen.SpringWeb;

// https://ithelp.ithome.com.tw/articles/10193631

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.Controller;

@RestController
public class DemoApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/MyFirstPage")
    public String greeting(@RequestParam(value="title", required=false, defaultValue="xiao") String title, Model model) {
        model.addAttribute("name", title);
        return "index";
    }
}