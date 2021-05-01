package com.yen.tweet.config;

// p.67 p.76 p.109

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// UDF
import com.yen.tweet.date.USLocalDateFormatter;
import org.springframework.web.util.UrlPathHelper;

import java.time.LocalDate;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override public void addFormatters(FormatterRegistry registry){
        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }

    @Override public void configurePathMatch(PathMatchConfigurer configurer){
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
        configurer.setUseSuffixPatternMatch(true);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }
}
