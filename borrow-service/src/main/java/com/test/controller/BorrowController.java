package com.test.controller;

import com.test.mapper.BorrowMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class BorrowController {
    @Resource
    BorrowMapper mapper;
}
