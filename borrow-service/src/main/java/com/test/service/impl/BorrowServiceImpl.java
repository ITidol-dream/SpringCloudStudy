package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import com.test.entity.UserBorrowDetail;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper,Borrow> implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Resource
    RestTemplate restTemplate;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        List<Borrow> list = borrowMapper.selectList(wrapper);
        User user = restTemplate.getForObject("http://userclient/user/find/"+uid, User.class);

        List<Book>  list1 = list
                .stream()
                .map(a -> restTemplate.getForObject("http://bookclient/book/find/"+a.getBid(),Book.class))
                .toList();

        return new UserBorrowDetail(user,list1);






    }
}