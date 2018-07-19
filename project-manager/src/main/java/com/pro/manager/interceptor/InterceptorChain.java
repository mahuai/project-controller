package com.pro.manager.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.interceptor project-controller
 * @date: Created in 2018/7/1313:48
 */
@Configuration
public class InterceptorChain implements WebMvcConfigurer {

    @Bean
    public InitInterceptor initInterceptor() {
        return new InitInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //初始化basePath adminInfo
        registry.addInterceptor(initInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/static/**");
        //登录拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/", "/admin/login");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
