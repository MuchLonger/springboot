package com.cq.springbootdata.controller;

import com.cq.springbootdata.bean.Department;
import com.cq.springbootdata.mapper.DepartmentMapper;
import com.cq.springbootdata.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Time: 2019/3/19 23:15
 */
@CacheConfig(cacheNames = "emp")
@RestController
public class DepController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepService depService;


    @RequestMapping("/queryById/{id}")
    /**
     * @Cacheable 注解的几个属性：
     *      cacheNames || value：指定缓存组件的名字：因为CacheManager有多个Cache组件，于是就得给容器添加 唯一 的一个名字
     *      key：因为缓存数据使用的是key-value，所以可以指定key值，默认是方法参数的具体值（#id）
     *           这里可以使用SPEL表达式，如现在#id就是获取到参数id的值
     *      keyGenerator: key的生成器（因为key默认行为也是由生成器产生的，所以直接指定生成器的效果和key的一样的）
     *                    注意：key和keyGenerator只能选一个使用。
     *      cacheManager: 指定缓存的管理器，或者使用cacheResolver指定获取解析器（效果一样），如Redis等，
     *      condition：在符合条件的情况下才缓存。（if）
     *                 如 condition= "#id>0"
     *      unless：否定缓存，当unless指定的条件为true，就 不缓存
     *                如：unless="#result == null"，结果为null时就不缓存
     *      sync：是否使用异步模式
     */
    //如下的作用分别是：将缓存名置为"dep",使用自己定义的KeyGenerator，当第一个参数大于2的时候才缓存，当结果为空时就不缓存
    @Cacheable(cacheNames = {"dep"})
    public Department queryById(@PathVariable("id") Integer id){
        System.out.println("查询"+id+"号员工");
        return departmentMapper.queryById(id);
    }

    @RequestMapping("/deleteById/{id}")
    @CacheEvict(value = "dep",allEntries = true)
    public String  deleteById(@PathVariable("id") Integer id){
        System.out.println(id+"被删除了");
//        return departmentMapper.deleteById(id);
        return "success";
    }
//    @RequestMapping("/insertByDep/{departmentName}")
//    public Department insertByDep(@PathVariable("departmentName") String departmentName){
//        Department department=new Department();
//        department.setDepartmentName(departmentName);
//        departmentMapper.insertByDep(department);
//        return department;
//    }
    @RequestMapping("/insertByDep")
    public Department insertByDep(Department department){
        departmentMapper.insertByDep(department);
        return department;
    }

    @RequestMapping("/updateByDep")
    @CachePut(value = "dep",key = "#result.id")
    /**
     * @CachePut的作用是既调用方法，又更新缓存
     * 常用于数据的更新
     */
    public Department updateByDep(Department department){
        System.out.println("更新"+department.getDepartmentName()+"员工");
        departmentMapper.updateByDep(department);
        return department;
    }


    @RequestMapping("/queryByDep")
//    @Cacheable(cacheNames = {"dep"},key = "#department.departmentName")
    public Department queryByDep(Department departmentName){
        return depService.queryByDep(departmentName);
    }

    @RequestMapping("/queryByDe")
    @Cacheable(cacheNames = {"dep"},key = "#a0.departmentName")
    public Department queryByDe(Department departmentName){
        System.out.println(111);
        return departmentName;
//        return depService.queryByDep(departmentName);
    }



}
