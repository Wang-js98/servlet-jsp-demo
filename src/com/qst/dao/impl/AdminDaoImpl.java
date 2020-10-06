package com.qst.dao.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.BaseDao;
import com.qst.pojo.User;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public int addAdmin(User user) {
        String sql="insert into user(userName,password,userType,status,createTime) values(?,?,?,?,?)";
        return update(sql,user.getUserName(),user.getPassword(),3,user.getStatus(),
                user.getCreatTime());
    }
}
