package com.Redis.redisCatch.entity;

import java.io.Serializable;

/**
 * @Author: MaoLin
 * @Date: 2019/3/24 14:36
 * @Version 1.0
 */


public class User implements Serializable {

    private int userId;

    private String userName;

    private String userPassword;

    public User() {
    }

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
