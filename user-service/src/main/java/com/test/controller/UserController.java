package com.test.controller;

import com.test.entity.Book;
import com.test.entity.User;
import com.test.service.UserService;



import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/find/{uid}")
    User getUserById(@PathVariable ("uid") Integer uid){

        System.out.println("我被调用了");
        return  userService.getById(uid);
    }


}
