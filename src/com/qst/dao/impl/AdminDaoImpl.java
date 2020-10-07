package com.qst.dao.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.BaseDao;
import com.qst.pojo.User;

import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public int addAdmin(User user) {
        String sql="insert into user(userName,password,userType,status,createTime) values(?,?,?,?,?)";
        return update(sql,user.getUserName(),user.getPassword(),3,user.getStatus(),
                user.getCreatTime());
    }

    @Override
    public List<User> queryUsers() {
        String sql="select userId,userName,password,userType,status,createTime from user";
        return queryForList(User.class,sql);
    }

    @Override
    public List<User> queryStudents() {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userType=1";
        return queryForList(User.class,sql);
    }

    @Override
    public List<User> queryTeachers() {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userType=2";
        return queryForList(User.class,sql);
    }

    @Override
    public List<User> queryAdmins() {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userType=3";
        return queryForList(User.class,sql);
    }

    @Override
    public int deleteAdminId(Integer id) {
        String sql="delete from user where id=?";
        return update(sql,id);
    }

    @Override
    public User queryByUsername(String userName) {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userName=?";
        return queryForOne(User.class,sql,userName);
    }


}
