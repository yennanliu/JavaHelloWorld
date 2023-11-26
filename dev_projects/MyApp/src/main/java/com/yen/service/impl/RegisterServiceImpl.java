package com.yen.service.impl;

import com.yen.service.RegisterService;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterServiceImpl implements RegisterService {

    //private HashMap<String, Object> map;
    private ConcurrentHashMap<String, Object> map;

    // ConcurrentHashMap

    public RegisterServiceImpl(){

        map = new ConcurrentHashMap();
    }

    public RegisterServiceImpl(ConcurrentHashMap<String, Object> map){
        this.map = map;
    }

    @Override
    public Boolean isExisted(String address) {
        return map.containsKey(address);
    }

    @Override
    public Boolean register(String address) {

        if(map.keySet().size() >= 10){
            System.out.println("Already saved 10 Keys");
            return false;
        }

        if (map.containsKey(address)){
            System.out.println("Key already existed");
            return false;
        }

        String randomId = UUID.randomUUID().toString();
        map.put(address, randomId);
        return true;
    }

    @Override
    public Boolean validate(String address) {

        // 127.0.0.1
        // check if only numeric digit
        //if ()

        return null;
    }

}
