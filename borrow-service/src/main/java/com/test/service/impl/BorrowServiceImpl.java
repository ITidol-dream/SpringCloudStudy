package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import com.test.service.client.BookClient;
import com.test.service.client.UserClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper,Borrow> implements BorrowService {

    @Autowired
    BorrowMapper borrowMapper;
    @Autowired
    BookClient bookClient;
    @Autowired
    UserClient userClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        System.out.println("正常执行");
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        List<Borrow> list = borrowMapper.selectList(wrapper);
        User user = userClient.getUserById(uid);
        List<Book>  list1 = list
                .stream()
                .map(a -> bookClient.getBookById(a.getBid()))
                .toList();

        return new UserBorrowDetail(user,list1);

    }
}