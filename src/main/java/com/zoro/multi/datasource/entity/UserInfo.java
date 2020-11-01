package com.zoro.multi.datasource.entity;

import java.io.Serializable;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 0:40
 * @desc
 */
public class UserInfo implements Serializable {
    private int id ;

    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
