package com.cq.springbootactuator.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @Time: 2019/4/9 23:55
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //    只要返回一个视图解析器就可以将其注入到springboot容器中
    @Bean   //记得加入@Bean注解加进容器内
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
            }
        };
        return webMvcConfigurer;
    }
}