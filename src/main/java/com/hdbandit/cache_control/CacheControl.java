package com.hdbandit.cache_control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheControl {
    
    boolean isReusableResponse();
    
    boolean isRequiredRevalidateEachTime();
    
    boolean isCacheableByIntermediateCaches();
    
    int maxAgeInSeconds();

}
