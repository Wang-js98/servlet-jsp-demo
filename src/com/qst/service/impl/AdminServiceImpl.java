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



    public int userStatus(int status,int userId){
        if(status==0){
            return adminDao.changeStatus(1,userId);
        }else{
            return adminDao.changeStatus(0,userId);
        }
    }

    @Override
    public int deleteAdminId(int userId) {
       return adminDao.deleteAdminId(userId);
    }

    @Override
    public List<User> queryUserByTag(String userName, int userType) {
        System.out.println(userType);
        if(("".equals(userName))&&(userType==0)){
            return null;
        }else if((!"".equals(userName))&&userType==0){
            return adminDao.queryByUsername2(userName);
        }else if(("".equals(userName))&&userType!=0){
            return adminDao.queryByUserType(userType);
        }else {
            return adminDao.queryByAll(userName,userType);
        }
    }

    @Override
    public User queryByUsername(String userName) {
        return adminDao.queryByUsername(userName);
    }
}
