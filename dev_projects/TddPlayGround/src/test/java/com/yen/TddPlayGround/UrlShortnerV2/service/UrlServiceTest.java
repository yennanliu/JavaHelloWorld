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
import static org.mockito.Mockito.when;

// https://www.tpisoftware.com/tpu/articleDetails/1294

@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @Mock
    RedisConfiguration redisConfiguration;

    @InjectMocks
    UrlServiceImpl urlService; // TOOD : fix this

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    @Test
    public void shouldGetUrlIfKeyExist(){

//        when(urlService.getUrlByKey(anyString())).thenReturn("https://short_url/abc");
        System.out.println(urlService.getUrlByKey("123"));
        assertEquals(urlService.getUrlByKey("some-key"), "https://short_url/abc");
    }


}