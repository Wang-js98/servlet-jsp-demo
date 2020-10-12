package com.qst.service.impl;

import com.qst.dao.CourseDao;
import com.qst.dao.impl.CourseDaoImpl;
import com.qst.pojo.Course;
import com.qst.pojo.Page;
import com.qst.pojo.User;
import com.qst.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao=new CourseDaoImpl();

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public Page<Course> queryCourse(int pageNo, int pageSize) {
        List<Course> courseList = courseDao.queryCourse(pageNo,pageSize);
        int total = courseDao.selectCount("course");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<Course> page = new Page<Course>();
        page.setCurrentPage(pageNo);
        page.setData(courseList);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public Page<Course> queryByCourseName(String c_name) {
        List<Course> courseList = courseDao.queryByCourseName(c_name);
        int total = courseDao.selectCount("course");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<Course> page = new Page<Course>();
        page.setCurrentPage(1);
        page.setData(courseList);
        page.setPageCount(pageCount);
        return page;

    }
    @Override
    public int deleteCourseById(Integer course_id) {
        return courseDao.deleteCourseById(course_id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }
}
