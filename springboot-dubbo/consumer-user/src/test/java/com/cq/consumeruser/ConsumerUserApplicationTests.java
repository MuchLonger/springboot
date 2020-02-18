package com.cq.consumeruser;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.cq.consumeruser.service.UserService;
import io.netty.util.NetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerUserApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.buyTicket();
    }
    @Test
    public void m1(){
        System.out.println(NetUtils.getLocalAddress());
    }

}
