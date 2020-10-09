package com.qst.service;

import com.qst.pojo.Student;
import com.qst.pojo.User;

import java.util.List;

public interface StudentService {
    //添加用户
    public void addUser(User user);
    public void addStudent(Student student);
    //查询所有学生信息
    public List<Student> queryStudents();
    //根据学生姓名查询
    public Student queryByStudentName(String userName);
}
