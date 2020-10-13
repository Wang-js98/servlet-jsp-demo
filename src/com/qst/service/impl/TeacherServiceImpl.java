package com.qst.service.impl;

import com.qst.dao.AdminDao;
import com.qst.dao.TeacherDao;
import com.qst.dao.impl.AdminDaoImpl;
import com.qst.dao.impl.TeacherDaoImpl;
import com.qst.pojo.Page;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.pojo.WorkArrange;
import com.qst.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao=new TeacherDaoImpl();
    AdminDao adminDao=new AdminDaoImpl();

    @Override
    public void addTeacher(User user,Teacher teacher) {
        teacherDao.addUser(user);
        teacherDao.addTeacher(teacher);
    }

    @Override
    public Page<Teacher> queryTeachers(int pageNo, int pageSize) {
        List<Teacher> list = teacherDao.queryTeachers(pageNo,pageSize);
        int total = adminDao.selectCount("teacher");
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;

        Page<Teacher> page = new Page<Teacher>();
        page.setCurrentPage(pageNo);
        page.setData(list);
        page.setPageCount(pageCount);
        return page;
    }



    @Override
    public List<Teacher> queryTeachersByEducation(String education) {
        return teacherDao.queryTeachersByEducation(education);
    }

    @Override
    public List<Teacher> queryTeachersByTags(String t_name, String education) {

        if(("".equals(t_name))&&education.equals("default")){
            return null;
        }else if((!"".equals(t_name))&&(!("default".equals(education)))){

            return teacherDao.queryTeachersByTags(t_name,education);
        }else if(("".equals(t_name))&&!("default".equals(education))){
            return teacherDao.queryTeachersByEducation(education);
        }else {

            List<Teacher> list = teacherDao.queryByTeacherName(t_name);
            System.out.println("3");
            System.out.println(list);
            return list;
        }
    }

    @Override
    public List<WorkArrange> queryWork(int t_id) {

       return teacherDao.searchWork(t_id);
    }

    @Override
    public void updateWork(int t_id, int course_id, String []c_id) {
        teacherDao.updateTeaCourse(t_id,course_id);
        teacherDao.deleteTeaClass(t_id);
        for(int i = 0;i<c_id.length;i++) {
           int class_id= Integer.parseInt(c_id[i]);
            teacherDao.insertTeaClass(t_id,class_id);
        }

    }
}
