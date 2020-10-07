package com.qst.service.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.pojo.User;
import com.qst.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao=new AdminDaoImpl();
    @Override
    public void addAdmin(User user) {

        adminDao.addAdmin(user);
    }

    @Override
    public List<User> queryUsers() {
        return adminDao.queryUsers();
    }

    @Override
    public List<User> queryStudents() {
        return adminDao.queryStudents();
    }

    @Override
    public List<User> queryTeachers() {
        return adminDao.queryTeachers();
    }

    @Override
    public List<User> queryAdmins() {
        return adminDao.queryAdmins();
    }

    @Override
    public User queryByUsername(String userName) {
        return adminDao.queryByUsername(userName);
    }


}
