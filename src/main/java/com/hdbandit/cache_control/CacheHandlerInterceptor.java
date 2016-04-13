package com.hdbandit.cache_control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CacheHandlerInterceptor extends HandlerInterceptorAdapter {
       
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if (handler instanceof HandlerMethod) {
           HandlerMethod handlerMethod = (HandlerMethod) handler;
           CacheControl cacheControl = handlerMethod.getMethod().getAnnotation(CacheControl.class);
           
           if (cacheControl != null) {
              StringBuilder sb = new StringBuilder();
               
               if (cacheControl.isReusableResponse()) {
                   
                   if (cacheControl.isRequiredRevalidateEachTime()) {
                       sb.append("no-cache, ");
                   }
                   
                   if (cacheControl.isCacheableByIntermediateCaches()) {
                       sb.append("public, ");
                   } else {
                       sb.append("private, ");
                   }
                   
                   sb.append("max-age=" + cacheControl.maxAgeInSeconds());
                   
               } else {
                   sb.append("no-store");
               }
               
               response.addHeader("Cache-Control", sb.toString());
           }
       }
       
       return true;
    }
   
}
