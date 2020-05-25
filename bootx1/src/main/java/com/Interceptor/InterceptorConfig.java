package com.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableWebMvc
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    public static Map<Object, Object> sessionMap = new ConcurrentHashMap();

    @Autowired
    private SessionInterceptor SessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(SessionInterceptor).addPathPatterns("/**");
    }
}
