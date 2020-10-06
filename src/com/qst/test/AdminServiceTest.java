package com.qst.test;

import com.qst.pojo.User;
import com.qst.service.AdminService;
import com.qst.service.impl.AdminServiceImpl;
import org.junit.Test;

import java.util.Date;

public class AdminServiceTest {
    AdminService adminService=new AdminServiceImpl();

    @Test
   public void addAdmin() {

        adminService.addAdmin(new User(null,"我是管理员","123456",3,1,new Date()));
    }
}