package com.cq.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Time: 2019/3/19 10:36
 */
@Controller
public class QueryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> query(){
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }

}
