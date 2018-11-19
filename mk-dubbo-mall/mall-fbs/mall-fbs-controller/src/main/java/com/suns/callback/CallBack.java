package com.suns.callback;

import com.suns.entity.OrderEntiry;

/**
 * Created by Peter on 11/13 013.
 */
public class CallBack {

    //第一个参数，为返回结果值，后续参数是入参
    public void onOrderSubmit(OrderEntiry orderEntiry,OrderEntiry from){
        System.out.println("onOrderSubmit..."+orderEntiry + ",from:"+from);
    }

    //第一个参数，为返回结果值，后续参数是入参
    public void onError(Exception e){
        System.out.println("onError...");
        e.printStackTrace();
    }
}
