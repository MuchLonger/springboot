package com.cq.springbootdata.controller;

import com.cq.springbootdata.bean.Employee;
import com.cq.springbootdata.mapper.EmployeeMapper;
import com.cq.springbootdata.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Time: 2019/3/20 11:22
 */
@RestController
public class EmpController {
    @Autowired
    private EmpService EmpService;

//    @Cacheable(cacheNames = "emps")
    @RequestMapping("/queryEmpById/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        System.out.println("查询"+id+"号员工");
        return EmpService.queryById(id);
    }

    public Employee queryEmpByIds(@PathVariable("id") Integer id){
        System.out.println("查询"+id+"号员工");
        return EmpService.queryById(id);
    }

}
