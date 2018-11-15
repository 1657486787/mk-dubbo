package com.suns.service.impl;

import com.suns.dao.UserDao;
import com.suns.entity.UserEntiry;
import com.suns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserEntiry getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        return userDao.getDetail(id);
    }

    @Override
    public UserEntiry regist(UserEntiry user) {
        return null;
    }

    @Override
    public UserEntiry recharge(String id, long money) {
        return null;
    }

}
