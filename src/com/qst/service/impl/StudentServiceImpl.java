package com.qst.service.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.StudentDao;
import com.qst.dao.TeacherDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.dao.impl.StudentDaoImpl;
import com.qst.dao.impl.TeacherDaoImpl;
import com.qst.pojo.Page;
import com.qst.pojo.Student;
import com.qst.pojo.User;
import com.qst.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    TeacherDao teacherDao=new TeacherDaoImpl();
    AdminDao adminDao=new AdminDaoImpl();

    @Override
    public Page<Student> queryStus(int pageNo, int pageSize) {
        List<Student> list=studentDao.queryStus(pageNo,pageSize);
        int total = adminDao.selectCount("student");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<Student> page = new Page<Student>();
        page.setCurrentPage(pageNo);
        page.setData(list);
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public int addStudent(User user, Student student) {
       int i = teacherDao.addUser(user);
       int j= studentDao.addStudent(student);
       return i+j;
    }

    @Override
    public List<Student> searchStu(String s_name) {
        List<Student> list = studentDao.queryByStudentName(s_name);
        return list;
    }
}

