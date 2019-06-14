package com.laycoding.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       // registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/");
       registry.addResourceHandler("/upload/**").addResourceLocations("file:/var/local/upload/");
    }
}
