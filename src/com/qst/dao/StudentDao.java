package com.qst.dao;

import com.qst.pojo.Student;
import com.qst.pojo.User;

public interface StudentDao {

    //添加用户
    public int addUser(User user) ;

    //添加学生
    public int addStudent(Student student) ;
}
