package com.suns.service.impl.eventNotify;

public interface Notify {
    void onreturn(String returnResult,String requestParam);
    void onthrow(Throwable ex,String requestParam);
}