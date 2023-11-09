package com.yen.TddPlayGround.ControllerTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
@Controller
public class ProductController {

    @GetMapping("/product/name")
    String getProductList(@RequestParam("name") String name){
        return "product name = " + name;
    }

}
