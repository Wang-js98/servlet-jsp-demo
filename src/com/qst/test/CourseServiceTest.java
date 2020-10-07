package com.qst.test;

import com.qst.pojo.Course;
import com.qst.pojo.Student;
import com.qst.service.CourseService;
import com.qst.service.impl.CourseServiceImpl;
import org.junit.Test;

import java.util.Date;


public class CourseServiceTest {
    private CourseService courseService=new CourseServiceImpl();
    @Test
    public void addCourse() {
        courseService.addCourse(new Course(null,"物理","万有引力",new Date()));
    }


    @Test
    public void queryCourse() {
        for (Course queryCourse:courseService.queryCourse()){
            System.out.println(queryCourse);
        }
    }
    @Test
    public void queryByCourseName() {
        System.out.println(courseService.queryByCourseName("物理"));
    }

}



