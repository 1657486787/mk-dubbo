package com.suns.dao;


import com.suns.entity.OrderEntiry;

public interface OrderDao {
    OrderEntiry getDetail(String id);
    OrderEntiry submit(OrderEntiry order);
    boolean cancel(OrderEntiry order);
}
