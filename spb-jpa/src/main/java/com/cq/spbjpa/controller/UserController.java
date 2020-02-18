package com.cq.spbjpa.controller;

import com.cq.spbjpa.entities.User;
import com.cq.spbjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Time: 2019/3/20 16:42
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/query/{id}")
    public User queryUserById(@PathVariable("id")Integer id){
        User user=userRepository.getOne(id);
        return user;
    }

    @GetMapping("/insert")
    public User insertByUser(User user){
        User save=userRepository.save(user);
        return save;
    }

}
