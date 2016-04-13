package com.hdbandit.cache_control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheControlConfig {

    @Bean
    public CacheHandlerInterceptor cacheControlInterceptor() {
       return new CacheHandlerInterceptor();
    }

}
