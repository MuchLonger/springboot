package com.cq.springbootdata;

import com.cq.springbootdata.bean.Employee;
import com.cq.springbootdata.controller.EmpController;
import com.cq.springbootdata.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.EmbeddedFrame;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmployeeMapper employeeMapper;


//    用来操作k-v都是字符串的
    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    用来操作k-v都是对象的
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
//    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * 操作Redis的五大数据类型
     * String、List、Set、Hash、zSet（有序集合）
     * stringRedisTemplate.opsForValue()：用来操作字符串，剩下的都相同：opsForZSet.....
     *
     */
    @Test
    public void m1(){
//        stringRedisTemplate.opsForValue().append("msg","cqy");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        System.out.println(stringRedisTemplate.opsForValue().get("msg").equals("helloworldcqy"));
    }

    @Test
    public void m2(){
        Employee e=employeeMapper.queryById(1);
//        如果要保存对象的话，默认会使用jdk机制，会将序列化的数据保存在redis内（就是一堆乱码）
//        可以用两个方法解决：
//          1）将对象转化为json（困难）
//          2）更改redisTemplate默认的序列化规则
//        redisTemplate.opsForValue().set("emp01",e);
//        以下是方法二，注意使用的是empRedis，即是自己定制的方法
        redisTemplate.opsForValue().set("emp05",e);
    }


    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();

        System.out.println(connection);
        connection.close();

    }





}
