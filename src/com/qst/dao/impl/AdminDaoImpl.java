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
    public List<User> queryUsers(int pageNo, int pageSize) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="select userId,userName,password,userType,status,createTime from user limit "+dataNum+","+pageSize;
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
        String sql="delete from user where userId=?";
        return update(sql,id);
    }



    @Override
    public int selectCount(String table_name) {
        String sql="SELECT COUNT(*) FROM "+table_name;
        Number count= (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public int changeStatus(int status,int userId) {
        String sql="update user set status=? where userId=?";
        return update(sql,status,userId);
    }



    @Override
    public List<User> queryByUsername2(String userName) {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userName=?";
        return queryForList(User.class,sql,userName);
    }

    @Override
    public List<User> queryByUserType(int userType) {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userType=?";
        return queryForList(User.class,sql,userType);
    }

    @Override
    public List<User> queryByAll(String userName, int userType) {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userName=? and userType=?";
        return queryForList(User.class,sql,userName,userType);
    }

    @Override
    public User queryByUsername(String userName) {
        String sql="select userId,userName,password,userType,status,createTime from user WHERE userName=?";
        return queryForOne(User.class,sql,userName);
    }
}
