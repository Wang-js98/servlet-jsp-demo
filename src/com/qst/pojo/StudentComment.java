package com.qst.pojo;

import java.util.Date;

public class StudentComment {
    private Integer s_id;
    private String s_name;
    private String userName;
    private Integer age;
    private Integer sex;
    private String comment;
    private Date createTime;
    private Integer c_id;
    private Integer t_id;
    private Integer c_id1;
    private String c_name;

    public StudentComment() {
    }

    public StudentComment(Integer s_id, String s_name, String userName, Integer age, Integer sex, String comment, Date createTime, Integer c_id, Integer t_id, Integer c_id1, String c_name) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.comment = comment;
        this.createTime = createTime;
        this.c_id = c_id;
        this.t_id = t_id;
        this.c_id1 = c_id1;
        this.c_name = c_name;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getC_id1() {
        return c_id1;
    }

    public void setC_id1(Integer c_id1) {
        this.c_id1 = c_id1;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "StudentComment{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                ", c_id=" + c_id +
                ", t_id=" + t_id +
                ", c_id1=" + c_id1 +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}
