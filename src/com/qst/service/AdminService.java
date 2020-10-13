package com.qst.service;

import com.qst.pojo.Page;
import com.qst.pojo.User;

import java.util.List;

public interface AdminService {
    //添加用户
    public void addAdmin(User user);
    //分页查询所有用户
    public Page<User> queryUsers(int pageNo, int pageSize);
    //查询所有学生
    public List<User> queryStudents();
    //查询所有老师
    public List<User> queryTeachers();
    //查询所有管理员
    public List<User> queryAdmins();


    public User queryByUsername(String userName);

    public int userStatus(int status,int userId);

    public int deleteAdminId(int userId);

    public List<User> queryUserByTag(String userName,int userType);
}
