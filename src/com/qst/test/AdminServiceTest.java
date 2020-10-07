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

    @Test
    public void queryStudents() {
        for (User queryStudent:adminService.queryStudents()){
            System.out.println(queryStudent);
        }
    }


    @Test
    public void queryTeachers() {
        for (User queryTeachers:adminService.queryTeachers()){
            System.out.println(queryTeachers);
        }
    }

    @Test
    public void queryAdmins() {
        for (User queryAdmins:adminService.queryAdmins()){
            System.out.println(queryAdmins);
        }
    }
    @Test
    public void queryUserByUserName() {
        System.out.println(adminService.queryByUsername("我是学生"));
    }

}