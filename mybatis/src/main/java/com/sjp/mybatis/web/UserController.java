package com.sjp.mybatis.web;

import com.sjp.mybatis.mapper.UserMapper;
import com.sjp.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userMapper.getAll();
    }
}
