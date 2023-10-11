package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.entity.Borrow;
import com.test.entity.UserBorrowDetail;
import org.springframework.stereotype.Service;

@Service
public interface BorrowService extends IService<Borrow> {
      UserBorrowDetail getUserBorrowDetailByUid(Integer uid);

}