package com.yen.SpringWeb;

// https://ithelp.ithome.com.tw/articles/10193631

import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.Controller;

// TODO : fix why can not use @Controller in the project
@RestController
public class DemoApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/MyFirstPage")
    public String greeting(@RequestParam(value="title", required=false, defaultValue="HI THIS IS MY JAVA WEB PAGE") String title, Model model) {
        model.addAttribute("name", title);
        return "HI THIS IS MY JAVA WEB PAGE";
    }
}