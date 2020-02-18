package com.cq.springbootdata.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @Time: 2019/3/19 23:01
 */
public class Department implements Serializable {
    private Integer id;
    private String departmentName;

    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
