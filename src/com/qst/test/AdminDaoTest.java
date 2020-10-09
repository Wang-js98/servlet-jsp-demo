package com.qst.test;

import com.qst.dao.AdminDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.pojo.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class AdminDaoTest {

    AdminDao adminDao=new AdminDaoImpl();
    @Test
    public void addAdmin() {

        adminDao.addAdmin(new User(null,"我是管理员","123456",3,1,new Date()));
    }


    @Test
    public void queryStudents() {
        for (User queryStudent:adminDao.queryStudents()){
            System.out.println(queryStudent);
        }
    }


    @Test
    public void queryTeachers() {
        for (User queryTeachers:adminDao.queryTeachers()){
            System.out.println(queryTeachers);
        }
    }

    @Test
    public void queryAdmins() {
        for (User queryAdmins:adminDao.queryAdmins()){
            System.out.println(queryAdmins);
        }
    }
    @Test
    public void queryUserByUserName() {
        System.out.println(adminDao.queryByUsername("stu1"));
    }



}