package com.qst.pojo;

import java.util.Date;

public class User {

    private Integer userId;
    private String userName;
    private String password;
    private Integer userType;
    private Integer status;
    private Date creatTime;

    public User() {
    }

    public User(Integer userId, String userName, String password, Integer userType, Integer status, Date creatTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.status = status;
        this.creatTime = creatTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", status=" + status +
                ", creatTime=" + creatTime +
                '}';
    }
}
