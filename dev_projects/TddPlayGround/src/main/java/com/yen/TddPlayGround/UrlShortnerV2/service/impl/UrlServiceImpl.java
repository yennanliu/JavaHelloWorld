package com.yen.TddPlayGround.UrlShortnerV2.service.impl;

// https://github.com/abinator-1308/urlshortener/blob/main/src/main/java/com/abinator/urlshortener/services/manager/impl/UrlManagerImpl.java

import com.yen.TddPlayGround.UrlShortner.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.service.UrlService;

// implements ICustomJpaService
public class UrlServiceImpl implements UrlService {

    public UrlServiceImpl(){

    }

    @Override
    public String getUrlByKey(String key) {

        return "https://short_url/abc";
    }

    @Override
    public Url shortenUrl(String url) {

        return null;
    }

}
