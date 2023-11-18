package com.yen.TddPlayGround.UrlShortnerV2.config;

import com.yen.TddPlayGround.UrlShortner.bean.Url;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/** Unit test for RedisConfiguration */


@ExtendWith(MockitoExtension.class)
class RedisConfigurationTest {

    private RedisConfiguration redisConfiguration;

    @BeforeEach
    public void before(){

        System.out.println(">>> before ...");
        // mock
    }

    @Test
    public void test1(){

        System.out.println(123);
    }

//    @Test
//    public void shouldReturnRedisTemplate(){
//
//        //Mockito.when()
//        RedisTemplate<String, Url> template = redisConfiguration.redisTemplate();
//        assertEquals(template, RedisTemplate.class);
//    }

}