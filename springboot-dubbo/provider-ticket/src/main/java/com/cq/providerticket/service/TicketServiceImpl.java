package com.cq.providerticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Time: 2019/4/4 20:47
 */
@Component  //注入容器
//以下这个Service是将服务发布出去
@Service    //注意，导入的包是com.alibaba.dubbo.config.annotation.Service
public class TicketServiceImpl  implements TicketService {
    @Override
    public String getTicket() {
        return "一张电影票";
    }
}
