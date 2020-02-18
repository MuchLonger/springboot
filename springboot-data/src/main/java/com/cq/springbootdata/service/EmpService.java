package com.cq.springbootdata.service;

import com.cq.springbootdata.bean.Employee;
import com.cq.springbootdata.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @Time: 2019/3/28 16:57
 */
@Service
public class EmpService {

    @Autowired
    private EmployeeMapper employeeMapper;

    //指明方法名为cacheManager
    @Qualifier("cacheManager")
    @Autowired
    private CacheManager cacheManager;

//    @Cacheable(cacheNames = "emps")
    public Employee queryById(Integer id){
        Employee employee=employeeMapper.queryById(id);
        System.out.println("进入了Service————queryEmpById");
        //获取cacheNames为emps的缓存，如果没有则创建
        Cache cache=cacheManager.getCache("emps");
        //将employee存入
        cache.put("emp"+employee.getId(),employee);
        return employee;
    }


}
