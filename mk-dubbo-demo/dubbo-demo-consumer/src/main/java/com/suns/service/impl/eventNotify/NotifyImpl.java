package com.suns.service.impl.eventNotify;

import java.util.HashMap;
import java.util.Map;

public class NotifyImpl implements Notify {
    public Map<String, String>    ret    = new HashMap<>();
    public Map<String, Throwable> errors = new HashMap<>();

    //参数要注意，第一个参数为返回的结果，后续参数是入参
    public void onreturn(String returnResult,String requestParam) {
        System.out.println("onreturn====>returnResult" + returnResult + ",requestParam="+requestParam);
        ret.put(requestParam, returnResult);
    }

    //参数要注意，第一个参数为返回的异常，后续参数是入参
    public void onthrow(Throwable ex,String requestParam) {
        System.out.println("onthrow====>requestParam="+requestParam +",Throwable=" + ex.getMessage());
        errors.put(requestParam, ex);
    }
}