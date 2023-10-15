package com.test.service.client;

import com.test.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient{
    @Override
    public Book getBookById(Integer bid) {
        System.out.println("book替代");
        Book book = new Book();
        book.setDescription("这是错误替代描述");
        book.setTitle("这是错误替代标题");
        return book;
    }
}
