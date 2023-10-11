package com.test.controller;

import com.test.entity.Book;
import com.test.entity.User;
import com.test.service.UserService;


import jakarta.annotation.Resource;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;
    @GetMapping("/find/{uid}")
    User getBookById(@PathVariable ("uid") String uid){

        System.out.println("我被调用了");
        return  userService.getById(uid);
    }


}
