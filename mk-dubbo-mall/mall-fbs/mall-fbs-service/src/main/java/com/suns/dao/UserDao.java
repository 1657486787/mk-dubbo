package com.suns.dao;


import com.suns.entity.UserEntiry;

public interface UserDao {
    UserEntiry getDetail(String id);
    UserEntiry regist(UserEntiry user);
    UserEntiry recharge(String id, long money);
}
