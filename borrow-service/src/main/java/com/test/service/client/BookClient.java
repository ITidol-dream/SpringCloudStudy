package com.test.service.client;

import com.test.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bookservice",fallback = BookFallbackClient.class)
public interface BookClient {

    @GetMapping("/book/find/{bid}")
    Book getBookById(@PathVariable("bid") Integer bid);
}
