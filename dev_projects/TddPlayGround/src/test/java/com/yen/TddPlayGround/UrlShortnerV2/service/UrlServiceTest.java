package com.yen.TddPlayGround.UrlShortnerV2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yen.TddPlayGround.UrlShortner.bean.Url;
import com.yen.TddPlayGround.UrlShortnerV2.config.RedisConfiguration;
import com.yen.TddPlayGround.UrlShortnerV2.service.impl.UrlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

// https://www.tpisoftware.com/tpu/articleDetails/1294
// https://hackmd.io/@KaiChen/H1R5Nq5FI

@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @Mock
    RedisConfiguration redisConfiguration;

//    @InjectMocks // InjectMocks can ONLY inject class, NOT interface
//    UrlServiceImpl urlService; // TODO : fix this

    /**
     *  Manually Create Mocks: If you want to mock an interface,
     *  you can create a mock manually using Mockito.mock(UrlService.class).
     */
    @Mock
    UrlService urlService;

    @BeforeEach
    public void before(){
        System.out.println("pre setup ...");
    }

    @Test
    public void shouldGetUrlIfInputNotNull(){

        // setup behaviour of mock instance method
        urlService = Mockito.mock(UrlService.class);
        when(urlService.getUrlByKey(anyString())).thenReturn("https://short_url/abc");

        //System.out.println(urlService.getUrlByKey("123"));
        assertEquals(urlService.getUrlByKey("some-key"), "https://short_url/abc");
    }

    @Test
    public void shouldCallOnce(){

        // setup behaviour of mock instance method
        urlService = Mockito.mock(UrlService.class);

        // NOTE : we call method, then verify below
        String result = urlService.getUrlByKey("some-key");

        // Verify that the method was called exactly once
        verify(urlService, times(1)).getUrlByKey(anyString());
    }

    @Test
    public void shouldReturnDifferentWhenDifferentInput(){

        urlService = Mockito.mock(UrlService.class);

        String result1 = urlService.getUrlByKey("some-key-1");
        String result2 = urlService.getUrlByKey("some-key-2");

        System.out.println(result1);

        assertNotNull(result1);
        assertNotEquals(result1, result2);
    }

    @Test
    public void shouldReturnSameWhenSameInput(){


    }


}