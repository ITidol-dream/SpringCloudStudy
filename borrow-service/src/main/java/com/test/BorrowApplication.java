package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import java.util.ArrayList;
@SpringBootApplication
@EnableHystrix
public class BorrowApplication {

    public static void main(String[] args) {

        SpringApplication.run(BorrowApplication.class,args);
    }
}
