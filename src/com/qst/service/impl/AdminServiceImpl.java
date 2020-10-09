package com.qst.service.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.pojo.Page;
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
    public Page<User> queryUsers(int pageNo, int pageSize) {
        List<User> list = adminDao.queryUsers(pageNo,pageSize);
        int total = adminDao.selectCount("user");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<User> page = new Page<User>();
        page.setCurrentPage(pageNo);
        page.setData(list);
        page.setPageCount(pageCount);
        return page;
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
