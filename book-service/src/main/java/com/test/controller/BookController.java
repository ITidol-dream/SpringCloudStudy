package com.test.controller;


import com.test.entity.Book;
import com.test.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/find/{bid}")
    Book getBookById(@PathVariable ("bid") Integer bid){
       return  bookService.getById(bid);
    }

}