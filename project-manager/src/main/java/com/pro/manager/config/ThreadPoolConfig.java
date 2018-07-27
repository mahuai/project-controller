package com.pro.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author ms
 * @Description:
 * @Package com.pro.manager.config
 * @date: Created in 2018/7/24 17:19
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(5);
        executor.initialize();
        return executor;
    }
}
