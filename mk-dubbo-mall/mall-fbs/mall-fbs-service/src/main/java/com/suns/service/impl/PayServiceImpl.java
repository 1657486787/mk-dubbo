package com.suns.service.impl;


import com.suns.service.PayService;

public class PayServiceImpl implements PayService {

    @Override
    public boolean pay(long money) {
        System.out.println("付款成功");
        return true;
    }

    @Override
    public boolean cancelPay(long money) {
        System.out.println("退款成功");
        return true;
    }
}
