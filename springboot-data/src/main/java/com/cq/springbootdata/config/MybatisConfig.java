package com.cq.springbootdata.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @description:
 * @Time: 2019/3/19 23:50
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
//                设置为“_”转驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
