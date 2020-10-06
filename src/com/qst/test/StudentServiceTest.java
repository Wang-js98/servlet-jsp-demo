package com.qst.test;


import com.qst.pojo.Student;
import com.qst.pojo.User;
import com.qst.service.StudentService;
import com.qst.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.Date;


public class StudentServiceTest {
    private StudentService studentService=new StudentServiceImpl();

    @Test
    public void addUser() {

        studentService.addUser(new User(null,"我是学生","123456",1,1,new Date()
        ));
    }

    @Test
    public  void addStudent() {
        studentService.addStudent(new Student(null,"我是学生","小王",15,1,"成绩优秀",new Date(),1
        ));
    }
}