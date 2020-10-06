package com.qst.pojo;

import java.util.Date;

public class Student {
    private Integer s_id;
    private String userName;
    private String s_name;
    private Integer age;
    private Integer sex;
    private String comment;
    private Date createTime;
    private Integer c_id;

    public Student() {
    }

    public Student(Integer s_id, String userName, String s_name, Integer age, Integer sex, String comment, Date createTime, Integer c_id) {
        this.s_id = s_id;
        this.userName = userName;
        this.s_name = s_name;
        this.age = age;
        this.sex = sex;
        this.comment = comment;
        this.createTime = createTime;
        this.c_id = c_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "student{" +
                "s_id=" + s_id +
                ", userName='" + userName + '\'' +
                ", s_name='" + s_name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                ", c_id=" + c_id +
                '}';
    }
}
