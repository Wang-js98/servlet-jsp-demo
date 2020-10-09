package com.qst.service.impl;

import com.qst.dao.StudentDao;
import com.qst.dao.impl.StudentDaoImpl;
import com.qst.pojo.Student;
import com.qst.pojo.User;
import com.qst.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    @Override
    public void addUser(User user) {
        studentDao.addUser(user);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.queryStudents();
    }

    @Override
    public Student queryByStudentName(String userName) {
        return studentDao.queryByStudentName(userName);
    }
}

