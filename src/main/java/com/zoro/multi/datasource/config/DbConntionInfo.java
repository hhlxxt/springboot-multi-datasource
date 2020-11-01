package com.zoro.multi.datasource.config;

import java.io.Serializable;

/**
 * @author zoro
 * @version 1.0
 * @date 2020/11/2 2:43
 * @desc
 */
public class DbConntionInfo implements Serializable {
    private String driverClassName ;
    private String url ;
    private String userName ;
    private String password ;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "DbConntionInfo{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
