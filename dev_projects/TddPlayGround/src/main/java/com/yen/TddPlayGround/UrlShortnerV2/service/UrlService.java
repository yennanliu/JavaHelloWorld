package com.yen.TddPlayGround.UrlShortnerV2.service;

// https://github.com/abinator-1308/urlshortener/blob/main/src/main/java/com/abinator/urlshortener/services/manager/UrlManager.java

import com.yen.TddPlayGround.UrlShortner.bean.Url;

public interface UrlService {
    public String getUrlByKey(String key);
    public Url shortenUrl(String url);
}
