package com.qst.dao;

import com.qst.pojo.Course;

import java.util.List;

public interface CourseDao {
    //添加课程
    public int addCourse(Course course);
    //查询所有课程信息
    public List<Course> queryCourse();
    //根据课程名称查询
    public Course queryByCourseName(String c_name);
}
