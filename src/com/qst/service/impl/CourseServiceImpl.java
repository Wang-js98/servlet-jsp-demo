package com.qst.service.impl;

import com.qst.dao.CourseDao;
import com.qst.dao.impl.CourseDaoImpl;
import com.qst.pojo.Course;
import com.qst.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao=new CourseDaoImpl();

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public List<Course> queryCourse() {
        return courseDao.queryCourse();
    }

    @Override
    public Course queryByCourseName(String c_name) {
        return courseDao.queryByCourseName(c_name);
    }
}
