package com.qst.dao;

import com.qst.pojo.Teacher;
import com.qst.pojo.User;

public interface TeacherDao {

    //添加用户
    public int addUser(User user) ;
    //添加老师
    public int addTeacher(Teacher teacher);
}
