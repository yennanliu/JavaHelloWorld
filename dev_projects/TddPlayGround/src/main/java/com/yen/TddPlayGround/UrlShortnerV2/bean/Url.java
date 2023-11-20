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

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

}
