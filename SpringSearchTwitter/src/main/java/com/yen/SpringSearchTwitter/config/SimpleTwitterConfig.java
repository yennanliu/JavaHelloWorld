package com.yen.SpringSearchTwitter.config;

// https://dzone.com/articles/getting-started-spring-social

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class SimpleTwitterConfig {

    private static Twitter twitter;

    public SimpleTwitterConfig() {

        if (twitter == null) {
            // TODO : find out what param we need to input TwitterTemplate
            twitter = new TwitterTemplate("123");
        }
    }

    /**
     * A proxy to a request-scoped object representing the simplest Twitter API
     * - one that doesn't need any authorization
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Twitter twitter() {
        return twitter;
    }

}