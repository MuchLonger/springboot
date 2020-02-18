package com.cq.spbjpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @description:
 * @Time: 2019/3/20 16:28
 */
//使用JPA注解配置映射关系
@Entity //告诉JPA这是实体类
@Table(name = "tb1_user")   //指定和哪个表数据对应，默认为小写类名（user）
public class User{
    //标志主键
    @Id
    //自增
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //配置列名为last_name，列长度为50
    @Column(name = "last_name",length = 50)
    private String lastName;
    //默认为字段名小写，当前即email
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
