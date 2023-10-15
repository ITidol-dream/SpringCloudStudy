package com.test.service.client;

import com.test.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient {
    @Override
    public User getUserById(Integer uid) {

        User user = new User();;
        user.setName("这是错误替代姓名");
        return user;
    }
}
