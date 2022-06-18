//package com.yen.SpringWeb.dev;
//
//import java.util.Map;
//
//import com.yen.SpringWeb.DemoApplication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//// UDF
//import com.yen.Service.UserService;
//
//@Controller
//public class UserController {
//    @Autowired
//    UserService userService;
//
//    @GetMapping("/")
//    public String index(Map<String, Object> model){
//        model.put("ID", userService.getUserId());
//        return "index";
//    }
//}
