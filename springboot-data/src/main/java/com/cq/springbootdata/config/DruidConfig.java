package com.cq.springbootdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Time: 2019/3/19 11:03
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //    配置一个管理后台的Servlet，采用的是ServletRegistrationBean的方式
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();

//        登陆后台用的用户名
        initParams.put("loginUsername", "cqy");
//        登陆后台的密码
        initParams.put("loginPassword", "123");
//        允许那些ip可以访问，现在默认是所有都能
        initParams.put("allow", "");
//        拒绝哪些ip访问,默认通过ip访问的被拒绝
        initParams.put("deny", "192.168.248.1");

//        将配置好的参数放入容器
        bean.setInitParameters(initParams);
        return bean;
    }

    //    配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);
//        拦截所有的请求，除了上面的exclusions，因为setUrlPatterns需要传入的是Collection所以需要转为List
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }


}
