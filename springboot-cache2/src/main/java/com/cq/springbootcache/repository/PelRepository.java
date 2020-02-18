package com.cq.springbootcache.repository;

import com.cq.springbootcache.bean.Man;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @Time: 2019/3/29 23:11
 */
public interface PelRepository extends ElasticsearchRepository<Man,Integer> {

}
