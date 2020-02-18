package com.cq.springbootcache.service;

import com.cq.springbootcache.bean.Man;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description:
 * @Time: 2019/3/29 15:37
 */
@Service
public class manService {
    @RabbitListener(queues = "springboot.second")
//    注意：这里的第一个参数要对应传入的参数，如传入的是Map，那么在这里接收的也应该是Map否则会报错，
//    如果传入的是一个对象，那方法内的参数（回传回来的值）也应该是这个对象,同时，这个对象要有一个无参构造器（反射的常识）
//    Message是amqp.core内的
    public void revice(Map map, Message message) {
        System.out.println("收到信息" + map);
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }
}
