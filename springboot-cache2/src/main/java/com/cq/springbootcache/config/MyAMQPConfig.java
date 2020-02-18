package com.cq.springbootcache.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @Time: 2019/3/29 15:20
 */
@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messagesConverer(){
        return new Jackson2JsonMessageConverter();
    }

}
