package com.zhstar.demo.nbamanager.entity;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.zhstar.demo.nbamanager.BR;

import java.io.Serializable;

public class User extends BaseObservable implements Serializable{


    private Long id;
    private String user_name;
    private String password;

    public User(String username, String password) {
        this.user_name = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Bindable
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
        notifyPropertyChanged(BR.user_name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

}
