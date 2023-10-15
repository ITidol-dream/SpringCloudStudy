package com.test.service.client;

import com.test.entity.Book;
import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {
    @GetMapping("/user/find/{uid}")
    User getUserById(@PathVariable ("uid") Integer uid);

}