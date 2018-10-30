package com.pro.manager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.config project-controller
 * @date: Created in 2018/7/11 15:27
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SpringMvcConfig.class);

    public SpringMvcConfig() {
        logger.info("init service----------->{}", SpringMvcConfig.class);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message/resultMessage");
        messageSource.setDefaultEncoding("GBK");
        return messageSource;
    }
}
