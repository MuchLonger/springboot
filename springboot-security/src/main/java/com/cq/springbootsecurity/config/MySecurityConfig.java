package com.cq.springbootsecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @Time: 2019/3/31 15:00
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置了下面这个之后 就可以用身份来限制用户不能干什么
        http.authorizeRequests()
                //premitAll表示所有的用户，意思是所有的用户都能进入"/"页面
                .antMatchers("/").permitAll()
                //限制Controller内"/level1"及底下的全部请求，必须得有"VIP1"的身份
                .antMatchers("/level1/**").hasRole("VIP1")
                //必须得有"VIP2"的身份才能访问"level2"底下的的请求
                .antMatchers("/level2/**").hasRole("VIP2")
                //同上 需要"VIP3"身份
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启登陆功能。
        http.formLogin()
                //开启定制登陆页面功能（即不用springboot默认的登录页）
                //注意：在html内的form表单内，提交的地址必须和下面的相同（/userlogin）且提交方法为post
                .loginPage("/userlogin")
                //因为不用springboot的默认登陆页面了，所以登陆的时候的参数（账号、密码）就需要自己定义name属性
                .usernameParameter("user")
                //在html页面内的name值属性填入 user 和 pwd 即可
                .passwordParameter("pwd");

        //开启注销功能，因为默认的注销后是返回登陆页面，就可以使用logoutSuccessUrl自定义指向哪个页面
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能（即使退出浏览器也会自动登陆）
        // 实现原理是：登陆之后会有个cookie，而开启这个功能之后这个cookie不会随着退出浏览器而删除，而是14天后自动删除
        http.rememberMe()
                //rememberMeParameter内的参数就是html内的name属性值
                .rememberMeParameter("rem");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //以下是搭配登陆功能使用的：inMemoryAuthentication（）意思是在内存中查询
        //passwordEncoder是security5.0新增的加密功能，如果不加会报错
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                //使用passwordEncoder的encode()方法重新加密密码即可。
                .withUser("cqy").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1","VIP2")
                //再添加一个
                .and()
                .withUser("cyy").password(new BCryptPasswordEncoder().encode("123")).roles("VIP2")
                .and()
                .withUser("cqq").password(new BCryptPasswordEncoder().encode("123")).roles("VIP3");
    }
}
