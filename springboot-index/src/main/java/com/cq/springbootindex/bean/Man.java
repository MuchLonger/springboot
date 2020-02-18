package com.cq.springbootindex.bean;


import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @description:
 * @Time: 2019/3/28 23:35
 */
@Document(indexName = "gduf",type = "students")
public class Man {
    private Integer id;
    private String sex;
    private String name;

    public Man(Integer id, String sex, String name) {
        this.id = id;
        this.sex = sex;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Man() {
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Man(Integer id, String sex) {
        this.id = id;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}