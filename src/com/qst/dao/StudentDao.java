package com.qst.dao;

import com.qst.pojo.Student;

import com.qst.pojo.User;

import java.util.List;

public interface StudentDao {



    //添加学生
    public int addStudent(Student student) ;
    //查询所有学生信息
    public List<Student> queryStus(int pageNo, int pageSize);
    //根据学生姓名查询
    public List<Student> queryByStudentName(String s_name);
}
