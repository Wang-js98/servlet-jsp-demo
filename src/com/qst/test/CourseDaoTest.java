package com.qst.test;

import com.qst.dao.CourseDao;
import com.qst.dao.impl.CourseDaoImpl;
import com.qst.pojo.Course;
import com.qst.pojo.Student;
import com.qst.service.CourseService;
import com.qst.service.impl.CourseServiceImpl;
import org.junit.Test;

import java.util.Date;

public class CourseDaoTest {
    private CourseDao courseDao=new CourseDaoImpl();
    @Test
    public void addCourse() {
        courseDao.addCourse(new Course(null,"物理","万有引力",new Date()));
    }

    @Test
    public void queryCourse() {
        for (Course queryCourse:courseDao.queryCourse()){
            System.out.println(queryCourse);
        }
    }
    @Test
    public void queryByCourseName() {
        System.out.println(courseDao.queryByCourseName("物理"));
    }

}