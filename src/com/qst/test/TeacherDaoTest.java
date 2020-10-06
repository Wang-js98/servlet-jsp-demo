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
        teacherDao.addTeacher(new Teacher(null,"我是老师","王五",40,1,"研究生",1));
    }
}