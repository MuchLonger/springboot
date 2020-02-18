package com.cq.springbootindex.repository;

import com.cq.springbootindex.bean.Man;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @description:
 * @Time: 2019/3/30 17:29
 */
public interface PelRepository extends ElasticsearchRepository<Man,Integer> {
    List<Man> findByNameAndSexLike(String name,String sex);
}
