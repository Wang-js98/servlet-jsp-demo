package com.qst.test;

import com.qst.dao.AdminDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.pojo.User;
import org.junit.Test;

import java.util.Date;

public class AdminDaoTest {

    AdminDao adminDao=new AdminDaoImpl();
    @Test
    public void addAdmin() {

        adminDao.addAdmin(new User(null,"我是管理员","123456",3,1,new Date()
));
    }
}