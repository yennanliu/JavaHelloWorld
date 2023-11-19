package com.yen.TddPlayGround.UrlShortnerV2.bean;

import java.time.LocalDateTime;

public class Url {

    // attr
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime createdTime;

    // constructor
    public Url(){

    }

    public Url(String originalUrl, String shortUrl){
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }

    public Url(String originalUrl){
        this.originalUrl = originalUrl;
    }

}
