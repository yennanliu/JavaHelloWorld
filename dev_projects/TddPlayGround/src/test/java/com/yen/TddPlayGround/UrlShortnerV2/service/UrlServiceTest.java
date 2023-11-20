package com.yen.TddPlayGround.UrlShortnerV2.service;

import com.yen.TddPlayGround.UrlShortnerV2.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.repository.UrlRepository;
import com.yen.TddPlayGround.UrlShortnerV2.service.impl.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @Mock
    UrlRepository urlRepository;

    @InjectMocks
    UrlServiceImpl urlService;

    private String url_1;
    private String short_url_1;
    private String short_url_2;

    private String short_url_3;

    private String url_2;

    private String url_3;

    @BeforeEach
    public void before(){

        url_1 = "https/google.com";
        url_2 = "https/google.com";
        url_3 = "https://meta.com";
        short_url_1 = "https://short_url/abc";
        short_url_2 = "https://short_url/abc";
        short_url_3 = "https://short_url/xyz";
        System.out.println("before");
    }

    @Test
    public void shouldReturnShortUrlIfKeyExist(){

        Url url = new Url(url_1, short_url_1);
        // mock
        Mockito.when(urlRepository.findById(url_1)).thenReturn(Optional.of(url));
        // run
        Url res = urlService.getUrlByKey(url.getOriginalUrl());
        // verify
        assertEquals(res.getShortUrl(), short_url_1);
    }

    @Test
    public void shouldReturnSameUrlIfSameInput(){

        Url url = new Url(url_1, short_url_1);

        // mock
        Mockito.when(urlRepository.findById(url_1)).thenReturn(Optional.of(url));
        // run
        Url res1 = urlService.getUrlByKey(url_1);
        Url res2 = urlService.getUrlByKey(url_2);
        // verify
        assertEquals(res1, res2);
    }

    @Test
    public void shouldReturnDifferentUrlIfDifferentInput(){

        Url url = new Url(url_1, short_url_1);
        Url url2 = new Url(url_3, short_url_3);

        // mock
        Mockito.when(urlRepository.findById(url_1)).thenReturn(Optional.of(url));
        Mockito.when(urlRepository.findById(url_3)).thenReturn(Optional.of(url2));
        // run
        // verify
        assertNotNull(urlService.getUrlByKey(url_1).getShortUrl(), urlService.getUrlByKey(url_3).getShortUrl());
    }

    @Test
    public void shouldGetShortUrl(){

        Url url = new Url(url_1, short_url_1);
        // mock
        Mockito.when(urlRepository.findById(url_1)).thenReturn(Optional.of(url));

        System.out.println(urlService.shortenUrl(url_1));
    }

}