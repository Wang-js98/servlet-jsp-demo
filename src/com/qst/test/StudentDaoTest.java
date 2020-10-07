package com.qst.test;

import com.qst.dao.StudentDao;
import com.qst.dao.impl.StudentDaoImpl;
import com.qst.pojo.Student;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import org.junit.Test;

import java.util.Date;


public class StudentDaoTest {

    private StudentDao studentDao =new StudentDaoImpl();
    @Test
    public void addUser() {

        studentDao.addUser(new User(null,"stu5","123456",1,1,new Date()
        ));

    }

    @Test
    public void addStudent() {

        studentDao.addStudent(new Student(null,"stu5","小王",15,1,"成绩优秀",new Date(),1
        ));
    }

    @Test
    public void queryStudents() {
        for (Student queryStudents:studentDao.queryStudents()){
            System.out.println(queryStudents);
        }
    }
    @Test
    public void queryByStudentName() {
        System.out.println(studentDao.queryByStudentName("我是学生"));
    }

}