package com.javaxian.cleanarchitecture.mvpjava.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseQuery {

    @SerializedName("code")
    @Expose
    int code;

    @SerializedName("status")
    @Expose
    int status;

    @SerializedName("message")
    @Expose
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
