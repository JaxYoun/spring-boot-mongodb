package com.yang.springbootmongodb.controller;

import com.yang.springbootmongodb.entity.User;
import com.yang.springbootmongodb.mapper.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/7/7 17:58
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/findByName")
    public List<User> findUserByName() {
        return this.userRepository.findByName("yang");
    }

    @GetMapping("/findOneByName")
    public List<User> findOneByName() {
        return this.userRepository.findOneByName("yang");
    }

    @GetMapping("/insertOne")
    public void insertOne() {
        User user = User.builder().id(8L).title("java dev").build();
        this.userRepository.insert(user);
    }

}
