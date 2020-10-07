package com.qst.dao;

import com.qst.pojo.Student;

import com.qst.pojo.User;

import java.util.List;

public interface StudentDao {

    //添加用户
    public int addUser(User user) ;

    //添加学生
    public int addStudent(Student student) ;
    //查询所有学生信息
    public List<Student> queryStudents();
    //根据学生姓名查询
    public Student queryByStudentName(String userName);
}
