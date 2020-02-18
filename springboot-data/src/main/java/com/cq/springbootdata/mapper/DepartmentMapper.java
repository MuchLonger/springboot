package com.cq.springbootdata.mapper;

import com.cq.springbootdata.bean.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @Time: 2019/3/19 23:10
 */
//@Mapper
public interface DepartmentMapper {
    //useCache = true表示将会缓存本次查询结果，以提高下次查询速度；
    // flushCache = Options.FlushCachePolicy.FALSE表示查询时不刷新缓存；
    // timeout = 10000表示查询结果缓存10000秒
    @Options(useCache = true,flushCache = Options.FlushCachePolicy.FALSE,timeout = 10000)
    @Select("select * from department where id=#{id}")
    Department queryById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Delete("delete from department where id=#{id}")
    int deleteById(@Param("id") Integer id);

//    Options中的useGeneratedKeys代表是否使用自动生成的主键，keyProperty会将id再次回传给Controller内的department，猜测使用反射
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(w) values(#{departmentName})")
    int insertByDep(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateByDep(Department department);

    @Select("select * from department where departmentName=#{departmentName}")
    Department queryByDepName(String departmentName);
}
