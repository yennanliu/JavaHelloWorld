package com.yen.TddPlayGround.UrlShortnerV2.service.impl;

// https://github.com/abinator-1308/urlshortener/blob/main/src/main/java/com/abinator/urlshortener/services/manager/impl/UrlManagerImpl.java

import com.yen.TddPlayGround.UrlShortnerV2.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.repository.UrlRepository;
import com.yen.TddPlayGround.UrlShortnerV2.service.UrlService;
import com.yen.TddPlayGround.UrlShortnerV2.util.EncodeDecodeUtil;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

// implements ICustomJpaService
public class UrlServiceImpl implements UrlService {

    private final String header = "https://short_url/";

    private UrlRepository urlRepository;

    private EncodeDecodeUtil encodeDecodeUtil;

    public UrlServiceImpl(UrlRepository urlRepository){

        this.urlRepository = urlRepository;
    }

    @Override
    public Url getUrlByKey(String key) {

        Optional<Url> url = urlRepository.findById(key);
        return url.get();
    }

    @Override
    public String shortenUrl(String url) throws UnsupportedEncodingException {

        Optional<Url> res = urlRepository.findById(url);
        // if exist
        if (res != null){
            return res.get().getShortUrl();
        }
        // decode
        encodeDecodeUtil = new EncodeDecodeUtil();
        String encodeUrl = encodeDecodeUtil.encode(url);
        String shortUrl = header + encodeUrl;
        urlRepository.save(new Url(url, shortUrl));

        return shortUrl;
    }

}
