package com.javaxian.cleanarchitecture.mvpjava.domain.base;

public abstract class BaseResponse {

    public abstract void onSuccess();

    public void onError(Exception e) {}
}
