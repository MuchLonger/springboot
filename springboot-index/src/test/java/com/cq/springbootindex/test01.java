package com.cq.springbootindex;

import org.junit.Test;

/**
 * @description:
 * @Time: 2019/3/30 21:59
 */
public class test01 {
    String sql="delete from user where id=? and username=? and password=?";
    @Test
    public void m1(int count){
        Object[] args={1,2};
        int firstQ=sql.indexOf('?');
//        int lastQ=sql.lastIndexOf('?');
//        String subSql=sql.substring(0,firstQ)+args[0]+sql.substring(firstQ+1,lastQ)+args[1];
//        System.out.println(subSql);
        if(count<=0){

        }
    }
}
