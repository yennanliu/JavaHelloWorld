package com.yen.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Integer getUserId(){
        System.out.println("you are now in the UserService.getUserid method");
        int userId = 5;
        return userId;
    }
}
