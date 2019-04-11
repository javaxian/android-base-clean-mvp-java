package com.javaxian.cleanarchitecture.mvpjava.data.network.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestQuery {

    @SerializedName("user")
    @Expose
    String user;

    @SerializedName("password")
    @Expose
    String password;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
