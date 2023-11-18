package com.yen.TddPlayGround.UrlShortnerV2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yen.TddPlayGround.UrlShortner.bean.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    // attr
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisConnectionFactory connectionFactory;

    private RedisTemplate redisTemplate;

    // constructor
    public RedisConfiguration(){

        redisTemplate = RedisTemplate();
    }

    // method
    @Bean
    RedisTemplate<String, Url> RedisTemplate() {

        final RedisTemplate<String, Url> _redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer valueSerializer = new Jackson2JsonRedisSerializer(Url.class);
        valueSerializer.setObjectMapper(objectMapper);
        _redisTemplate.setConnectionFactory(connectionFactory);
        _redisTemplate.setKeySerializer(new StringRedisSerializer());
        _redisTemplate.setValueSerializer(valueSerializer);
        //redisTemplate = _redisTemplate;
        return _redisTemplate;
    }

    // TODO : verify if needed
    public RedisTemplate<String, Url> getRedisTemplate(){

        System.out.println("getRedisTemplate");
        return redisTemplate;
    }

}
