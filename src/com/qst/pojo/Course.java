package com.qst.pojo;

import java.util.Date;

public class Course {

    private Integer course_id;
    private String c_name;
    private String description;
    private Date createTime;

    public Course() {
    }

    public Course(Integer course_id, String c_name, String description, Date createTime) {
        this.course_id = course_id;
        this.c_name = c_name;
        this.description = description;
        this.createTime = createTime;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "course{" +
                "course_id=" + course_id +
                ", c_name='" + c_name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
