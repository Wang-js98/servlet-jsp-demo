package com.qst.dao;

import com.qst.pojo.Teacher;
import com.qst.pojo.User;

import java.util.List;

public interface TeacherDao {

    //添加用户
    public int addUser(User user) ;
    //添加老师
    public int addTeacher(Teacher teacher);
    //查询所有老师
    public List<Teacher> queryTeachers();
    //根据用户名查询老师
    public Teacher queryByTeacherName(String userName);
    //根据学历查询老师
    public List<Teacher> queryTeachersByEducation(String education);

}
