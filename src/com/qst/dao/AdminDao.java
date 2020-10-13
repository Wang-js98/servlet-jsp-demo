package com.qst.dao;

import com.qst.pojo.User;

import java.util.List;

public interface AdminDao {
    //添加管理员
    public int addAdmin(User user) ;
    //查询所有用户
    public List<User> queryUsers(int pageNo, int pageSize);
    //查询所有学生
    public List<User> queryStudents();
    //查询所有老师
    public List<User> queryTeachers();
    //查询所有管理员
    public List<User> queryAdmins();
    //删除管理员
    public int deleteAdminId(Integer id);
    //根据用户名查询
    public User queryByUsername(String userName);
    public List<User> queryByUsername2(String userName);
    //根据用户类型查询
    public List<User> queryByUserType(int userType);
    //根据 用户名 和 用户类型 查询
    public List<User> queryByAll(String userName,int userType);

    //查询指定表字段总数
    public int selectCount(String table_name);

    //改变用户状态
    public int changeStatus(int status,int userId);
}
