package com.test.controller;


import com.test.entity.Book;
import com.test.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    BookService bookService;
    @GetMapping("/find/{bid}")
    Book getBookById(@PathVariable ("bid") String bid){
       return  bookService.getById(bid);
    }

}