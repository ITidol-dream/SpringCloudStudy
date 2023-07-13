package com.test.controller;

import com.test.Mapper.BorrowMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BprrpwController {
    @Resource
    BorrowMapper mapper;
}
