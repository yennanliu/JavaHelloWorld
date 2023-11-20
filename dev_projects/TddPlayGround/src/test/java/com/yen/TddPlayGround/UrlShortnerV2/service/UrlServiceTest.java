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

    @BeforeEach
    public void before(){

        System.out.println("before");
    }

    @Test
    public void shouldReturnShortUrlIfKeyExist(){

        Url url = new Url("https/google.com", "https://short_url/abc");
        // mock
        Mockito.when(urlRepository.findById("https/google.com")).thenReturn(Optional.of(url));
        Url res = urlService.getUrlByKey(url.getOriginalUrl());
//        System.out.println(res);
//        System.out.println(res.getShortUrl());
        assertEquals(res.getShortUrl(), "https://short_url/abc");
    }

}