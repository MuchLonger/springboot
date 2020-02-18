package com.cq.springbootindex;

import com.cq.springbootindex.bean.Man;
import com.cq.springbootindex.repository.PelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootIndexApplicationTests {

    @Autowired
    private PelRepository pelRepository;

    @Test
    public void EsBySpringboot() {
//        Man pel=new Man(2,"男","陈麒涌");
//        pelRepository.index(pel);
        List<Man> men = pelRepository.findByNameAndSexLike("陈","男");
        for (Man m : men) {
            System.out.println(m);
        }
    }

    @Test
    public void contextLoads() {

    }

}
