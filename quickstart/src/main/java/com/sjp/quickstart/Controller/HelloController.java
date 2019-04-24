package com.sjp.quickstart.Controller;

import com.sjp.quickstart.Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/user")
    public User user() {

        User user=new User(1L,"xiaoming","123","121@qq.com","tomcat","2018");

        return user;
    }
}
