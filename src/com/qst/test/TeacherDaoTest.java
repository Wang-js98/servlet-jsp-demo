package com.qst.test;

import com.qst.dao.TeacherDao;
import com.qst.dao.impl.TeacherDaoImpl;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import org.junit.Test;

import java.util.Date;


public class TeacherDaoTest {

    TeacherDao teacherDao=new TeacherDaoImpl();
    @Test
    public void addUser() {

        teacherDao.addUser(new User(null,"我是老师","123456",2,1,new Date()
        ));
    }

    @Test
    public void addTeacher() {
        teacherDao.addTeacher(new Teacher(null,"我是老师","王五",40,1,"本科",1));
    }

    @Test
    public void queryByTeacherName() {
        System.out.println(teacherDao.queryByTeacherName("tea1"));
    }


    @Test
    public void queryTeachers() {
        for (Teacher queryTeachers:teacherDao.queryTeachers()){
            System.out.println(queryTeachers);
        }
    }
    @Test
    public void queryTeachersByEducation() {
        for (Teacher queryTeachersByEducation:teacherDao.queryTeachersByEducation("本科")){
            System.out.println(queryTeachersByEducation);
        }
    }
}