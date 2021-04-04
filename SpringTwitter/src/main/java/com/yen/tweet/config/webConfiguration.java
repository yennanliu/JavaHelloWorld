package com.yen.tweet.config;

// p.67

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// UDF
import com.yen.tweet.date.USLocalDateFormatter;

import java.time.LocalDate;

@Configuration
public class webConfiguration extends WebMvcConfigurerAdapter {
    @Override public void addFormatters(FormatterRegistry registry){
        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }
}
