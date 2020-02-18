package com.cq;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @Time: 2019/6/15 21:01
 */
public class test {
    @Test
    public void test01(){
        Integer[] arr={1,2,3,4,5,6,7,8,9,10};
//        Arrays.stream(arr).filter((x)->x/2==0).mapToObj((x)->x/2==0)
        List<Integer> arrList= Arrays.asList(arr);
        List<Integer> list=arrList.stream().filter((x)->x%2==0).map((x)->x+1).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
