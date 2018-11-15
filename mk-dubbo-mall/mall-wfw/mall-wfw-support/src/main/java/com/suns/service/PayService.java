package com.suns.service;

public interface PayService {
    boolean pay(long money);
    boolean cancelPay(long money);
}
