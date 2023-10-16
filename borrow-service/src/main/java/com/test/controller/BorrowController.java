package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService;
    @GetMapping("/find/{uid}")
    UserBorrowDetail getUserBorrowDetail(@PathVariable ("uid") Integer uid, HttpServletRequest request){
        System.out.println(request.getHeader("test"));
        return  borrowService.getUserBorrowDetailByUid(uid);
    }
}
