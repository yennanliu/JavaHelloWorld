package com.yen.TddPlayGround.UrlShortner.service;

public class ShortService {

    public boolean verify(String input) {

        if(input == null){
            return false;
        }
        return true;
    }

    public String split(String input) {

        if (input.contains("https")){
            return input.split("https://")[1];

        } else if (input.contains("http")) {
            return input.split("http://")[1];
        }
        System.out.println("not split, return original url");
        return input;
    }

}
