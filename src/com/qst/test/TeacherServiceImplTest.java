package com.qst.test;

import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.service.TeacherService;
import com.qst.service.impl.TeacherServiceImpl;
import org.junit.Test;

import java.util.Date;


public class TeacherServiceImplTest {

    TeacherService teacherService=new TeacherServiceImpl();
    @Test
    public void addUser() {
teacherService.addUser(new User(null,"我是老师","123456",2,1,new Date()));
    }

    @Test
    public void addTeacher() {
        teacherService.addTeacher(new Teacher(null,"我是老师","王五",40,1,"研究生",1));
    }

    @Test
    public void queryByTeacherName() {
        System.out.println(teacherService.queryByTeacherName("tea1"));
    }


    @Test
    public void queryTeachers() {
        for (Teacher queryTeachers:teacherService.queryTeachers()){
            System.out.println(queryTeachers);
        }
    }
    @Test
    public void queryTeachersByEducation() {
        for (Teacher queryTeachersByEducation:teacherService.queryTeachersByEducation("本科")){
            System.out.println(queryTeachersByEducation);
        }
    }
}