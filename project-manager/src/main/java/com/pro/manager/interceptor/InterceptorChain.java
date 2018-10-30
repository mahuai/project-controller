package com.pro.manager.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedList;
import java.util.List;

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

    @Bean
    public AuthorityInterceptor sessionInterceptor() {
        return new AuthorityInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathPatterns = new LinkedList<>();
        excludePathPatterns.add("/swagger-resources/**");
        excludePathPatterns.add("/webjars/**");
        excludePathPatterns.add("/v2/**");
        excludePathPatterns.add("/swagger-ui.html/**");
        excludePathPatterns.add("/csrf");
        excludePathPatterns.add("/error");
        //初始化basePath adminInfo
        registry.addInterceptor(initInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/", "/static/**").excludePathPatterns(excludePathPatterns);
        //登录拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/", "/admin/login", "/resource/*").excludePathPatterns(excludePathPatterns);
        //权限 拦截
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/", "/admin/login", "/resource/*").excludePathPatterns(excludePathPatterns);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
