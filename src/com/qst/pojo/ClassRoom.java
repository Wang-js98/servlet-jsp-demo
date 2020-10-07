package com.qst.pojo;

import java.util.Date;

public class ClassRoom {
    private Integer c_id;
    private String c_name;
    private Date createTime;

    public ClassRoom() {
    }

    public ClassRoom(Integer c_id, String c_name, Date createTime) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.createTime = createTime;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
