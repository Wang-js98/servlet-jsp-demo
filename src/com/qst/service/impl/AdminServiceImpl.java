package com.qst.service.impl;

import com.qst.pojo.User;
import com.qst.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminService adminService=new AdminServiceImpl();
    @Override
    public void addAdmin(User user) {

        adminService.addAdmin(user);
    }

    @Override
    public List<User> queryStudents() {
        return adminService.queryStudents();
    }

    @Override
    public List<User> queryTeachers() {
        return adminService.queryTeachers();
    }

    @Override
    public List<User> queryAdmins() {
        return adminService.queryAdmins();
    }

    @Override
    public User queryByUsername(String userName) {
        return adminService.queryByUsername(userName);
    }


}
