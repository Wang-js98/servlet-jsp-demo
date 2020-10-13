package com.qst.service;

import com.qst.pojo.Page;
import com.qst.pojo.Student;
import com.qst.pojo.User;

import java.util.List;

public interface StudentService {


    public int addStudent(User user,Student student);
    public List<Student> searchStu(String s_name);

    public Page<Student> queryStus(int pageNo, int pageSize);

    //添加用户
    public void addUser(User user);
    public void addStudent(Student student);

    //根据学生姓名查询
    public List<Student> queryByStudentName(String userName);

}
