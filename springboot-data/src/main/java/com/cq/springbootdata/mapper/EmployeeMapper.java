package com.cq.springbootdata.mapper;

import com.cq.springbootdata.bean.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @Time: 2019/3/20 11:14
 */
//因为配置了@MapperScan 所以不用添加@Mapper
public interface EmployeeMapper {
    Employee queryById(@Param("id") Integer id);

    int insertByEmp(Employee employee);

}
