package com.qst.dao;

import com.qst.pojo.Course;

import java.util.List;

public interface CourseDao {
    //添加课程
    public int addCourse(Course course);
    //分页查询查询所有课程信息
    public List<Course> queryCourse(int pageNo, int pageSize);
    //根据课程名称查询
    public List<Course> queryByCourseName(String c_name);
    //根据课程id删除课程
    public int deleteCourseById(Integer course_id) ;
    //修改课程
    public int updateCourse(Course course);

    //查询指定表字段总数
    public int selectCount(String table_name);
}
