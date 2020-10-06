package com.qst.service.impl;

import com.qst.pojo.User;
import com.qst.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminService adminService=new AdminServiceImpl();
    @Override
    public void addAdmin(User user) {

        adminService.addAdmin(user);
    }
}
