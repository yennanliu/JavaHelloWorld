package com.yen.TddPlayGround.UrlShortner.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class ShortService {

    final String prefix = "https://yen_shortner/";

    // attr
    private HashMap<String, String> map = new HashMap<>();

    // constructor
    ShortService(){
    }

    ShortService(HashMap<String, String> map){
        this.map = map;
    }

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

    public String shortener(String input) {

        // if exists, return directly
        if (this.map.containsKey(input)){
            return this.map.get(input);
        }

        // if not exists, make hash, save to map, and return
        //int len = input.length();
        // make some hash
        //int hash = len % 13;
        String uuid = UUID.randomUUID().toString().substring(0,5);
        String short_url = prefix + uuid;
        this.map.put(input, short_url);
        return short_url; // return "https://yen_shortner";
    }

    // getter, setter
    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String inverse(String input) {

        // TODO : optimize below (O(N) time complexity now)
        Collection<String> values = this.map.values();
        if (!values.contains(input)){
            System.out.println("Not a valid short URL");
            return null;
        }
        for (String key : this.map.keySet()){
            String val = this.map.get(key);
            if (val.equals(input)){
                return key;
            }
        }

        //return "https://google.com";
        System.out.println("Not a valid short URL");
        return null;
    }

}
