package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    BorrowService borrowService;
    @HystrixCommand(fallbackMethod = "onError")
    @GetMapping("/find/{uid}")
    UserBorrowDetail getUserBorrowDetail(@PathVariable ("uid") Integer uid){

        return  borrowService.getUserBorrowDetailByUid(uid);
    }
    UserBorrowDetail onError(Integer uid){
        System.out.println("补救措施");
        return new UserBorrowDetail(null, Collections.emptyList());
    }

}
