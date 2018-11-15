package com.suns.service;


import com.suns.entity.OrderEntiry;

public interface OrderService {
    OrderEntiry getDetail(String id);
    OrderEntiry submit(OrderEntiry order);
    boolean cancel(OrderEntiry order);
}
