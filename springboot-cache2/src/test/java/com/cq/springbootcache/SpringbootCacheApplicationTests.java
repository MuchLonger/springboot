package com.cq.springbootcache;

import com.cq.springbootcache.bean.Man;
import com.cq.springbootcache.repository.PelRepository;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    //用来在java中自己定义绑定关系（Binding）和交换机（exchange）和队列（queue）
    private AmqpAdmin amqpAdmin;

    @Autowired
    private PelRepository pelRepository;

    @Test
    public void EsBySpringboot(){
        Man pel=new Man(1,"男","cqy");
        pelRepository.index(pel);
    }


    @Test
    public void DeclareAmqp(){
        //新建交换机，需要new一个DirectExchange（或FanoutExchange等）对象可以设置交换机的名字，是否是持久化（durable）等属性
        amqpAdmin.declareExchange(new FanoutExchange("amqp.Exchange"));
        //新建一个队列，自定义名字，并且设置为持久化的
        amqpAdmin.declareQueue(new Queue("amqp.queue",true));
        //新建一个绑定关系，（目的队列名称，目的组件的类型（是给queue还是exchange），与哪个交换机建立联系，约定好的key值，其他的参数）
        //注意，这个绑定关系是双向的，即定义了这一句“队列到交换机”和“交换机到队列”都已经定义好了绑定关系，
        //当前的情况是，只会收到“amqp.Exchange”的信息，不会接受到其他交换机的信息
        amqpAdmin.declareBinding(new Binding("amqp.queue",Binding.DestinationType.QUEUE,
                "amqp.Exchange","amqp.FANOUT2QUEUE",null));
        //删除交换机示例
        amqpAdmin.deleteExchange("amqp.Exchange");
    }



    /**
     * 测试单播交换机（direct）
     */
    @Test
    public void direct2Publish() {
//          方法一：
//        message是需要自己构造的，可以定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message);
//          方法二：
//        object被默认当成消息体（即消息的内容就是他），只需要传入要发送的对象，springboot就会自动序列化然后发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routeKey,object);
//        使用方法二：
        Map<String,Object> map=new HashMap<>();
        Man pel=new Man(1,"男");
        map.put("msg","消息一");
        map.put("man",pel);
        map.put("data", Arrays.asList("hello",123,true));
        rabbitTemplate.convertAndSend("cq.direct","springboot.second",map );
    }

    @Test
    public void direct2Receive(){
        Object o=rabbitTemplate.receiveAndConvert("springboot.first");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //测试广播
    @Test
    public void fanout2Send(){
        //不用管路由键，因为广播不需要路由键
        rabbitTemplate.convertAndSend("cq.fanout","",new Man(2,"man"));
    }



}
