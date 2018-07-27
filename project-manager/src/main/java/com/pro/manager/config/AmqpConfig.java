package com.pro.manager.config;


import com.pro.manager.listener.AmqpChannelListener;
import com.pro.manager.listener.AmqpConnectionListener;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ms
 * @Description:
 * @Package com.admin.service.config
 * @date: Created in 2018/7/23 15:48
 */
@Configuration
public class AmqpConfig {


    @Bean
    public ConnectionFactory connection() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.addConnectionListener(new AmqpConnectionListener());
        factory.addChannelListener(new AmqpChannelListener());
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connection());
    }

    @Bean
    public RabbitTemplate amqpTemplate() {
        return new RabbitTemplate(connection());
    }

    @Bean
    public Queue queue() {
        return new Queue("amqp-queue");
    }
}
