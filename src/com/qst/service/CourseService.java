package com.qst.service;

import com.qst.pojo.Course;

import java.util.List;


public interface CourseService {
    //添加课程
    public void addCourse(Course course);

    //查询所有课程信息
    public List<Course> queryCourse();
    //根据课程名称查询
    public Course queryByCourseName(String c_name);
    //根据课程id删除课程
    public int deleteCourseById(Integer course_id) ;
    //修改课程
    public int updateCourse(Course course);
}
