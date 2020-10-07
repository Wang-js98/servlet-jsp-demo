package com.qst.service;

import com.qst.pojo.User;

import java.util.List;

public interface AdminService {
    //添加用户
    public void addAdmin(User user);
    //查询所有学生
    public List<User> queryStudents();
    //查询所有老师
    public List<User> queryTeachers();
    //查询所有管理员
    public List<User> queryAdmins();

    public User queryByUsername(String userName);

}
