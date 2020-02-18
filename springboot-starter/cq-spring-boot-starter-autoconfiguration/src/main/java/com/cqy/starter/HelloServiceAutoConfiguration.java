package com.cqy.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//标志为配置类
@Configuration
//只在Web环境下生效
@ConditionalOnWebApplication
//让配置的属性文件（class的方式）生效，如果没有这句话的话，下面的@Autowired会报错（找不到）
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {
    @Autowired
    private HelloProperties helloProperties;

    @Bean
    public HelloService helloService(){
        HelloService helloService=new HelloService();
//        将属性值自动注入后获取的属性值赋值上
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }


}
