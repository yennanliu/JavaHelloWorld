package com.yen.TddPlayGround.UrlShortnerV2.service;

// https://github.com/abinator-1308/urlshortener/blob/main/src/main/java/com/abinator/urlshortener/services/manager/UrlManager.java


import com.yen.TddPlayGround.UrlShortnerV2.bean.Url;

import java.io.UnsupportedEncodingException;

public interface UrlService {
    public Url getUrlByKey(String key);
    public String shortenUrl(String url) throws UnsupportedEncodingException;
}
