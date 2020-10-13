package com.qst.pojo;

import java.util.List;

public class WorkArrange {
    private int t_id;
    private String t_name;
    private int c_id; //课程id
    private String c_name;  //课程名称
    private int class_id;
    private String class_name;

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "WorkArrange{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
