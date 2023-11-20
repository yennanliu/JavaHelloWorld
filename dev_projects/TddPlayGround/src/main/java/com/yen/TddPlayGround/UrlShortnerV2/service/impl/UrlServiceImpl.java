package com.yen.TddPlayGround.UrlShortnerV2.service.impl;

// https://github.com/abinator-1308/urlshortener/blob/main/src/main/java/com/abinator/urlshortener/services/manager/impl/UrlManagerImpl.java

import com.yen.TddPlayGround.UrlShortnerV2.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.repository.UrlRepository;
import com.yen.TddPlayGround.UrlShortnerV2.service.UrlService;

import java.util.Optional;

// implements ICustomJpaService
public class UrlServiceImpl implements UrlService {

    private UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository){

        this.urlRepository = urlRepository;
    }

    @Override
    public Url getUrlByKey(String key) {

        Optional<Url> url = urlRepository.findById(key);
        return url.get();
    }

    @Override
    public String shortenUrl(String url) {

        Optional<Url> res = urlRepository.findById(url);
        // if exist
        if (res != null){
            return res.get().getShortUrl();
        }


        return null;
    }

}
