package com.cq.spbjpa.repository;

import com.cq.spbjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @Time: 2019/3/20 16:35
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
