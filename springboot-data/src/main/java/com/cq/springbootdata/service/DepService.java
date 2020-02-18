package com.cq.springbootdata.service;

import com.cq.springbootdata.bean.Department;
import com.cq.springbootdata.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @Time: 2019/3/22 23:03
 */
@Service
public class DepService {

    @Autowired
    private DepartmentMapper departmentMapper;


   /* @Caching(
            cacheable = {
                    @Cacheable(value = "dep", key = "#a0")
            }, put = {
            @CachePut(value = "dep", key = "#result.id")
    })
    public Department queryByDep(String departmentName) {
        System.out.println("查询" + departmentName);
        return departmentMapper.queryByDepName(departmentName);
    }*/
//    @Caching(
//            cacheable = {
//                    @Cacheable(value = "dep",key = "#a0.departmentName")
//            },put = {
//            @CachePut(value = "dep",key="#result.id")
//    })
    public Department queryByDep(Department department) {
        System.out.println("查询"+department.getDepartmentName());
        return departmentMapper.queryByDepName(department.getDepartmentName());
    }
}
