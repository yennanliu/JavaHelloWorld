package com.yen.TddPlayGround.ControllerMockTest;

// https://vivifish.medium.com/spring-boot-%E4%BD%BF%E7%94%A8-mockmvc-%E6%B8%AC%E8%A9%A6-controller-b9486c2ac1e6

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class DemoUserController {

    @Autowired
    private MockControllerUserService userService;

    @GetMapping(value = "/info")
    public Response<Void> info(@RequestParam String userId) {
        return Response.success(this.userService.getUserInfo(userId));
    }

}