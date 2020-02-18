package com.cq.consumeruser.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cq.consumeruser.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Time: 2019/4/4 20:51
 */
@Service    //使用的是springboot的Service，放入容器
public class UserService {
    @Reference  //使用dubbo的@Reference注解
    TicketService ticketService;

    public void buyTicket(){
        String ticket=ticketService.getTicket();
        System.out.println(ticket);
    }
}
