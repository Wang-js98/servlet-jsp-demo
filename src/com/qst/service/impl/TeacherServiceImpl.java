package com.qst.service.impl;

import com.qst.dao.TeacherDao;
import com.qst.dao.impl.TeacherDaoImpl;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao=new TeacherDaoImpl();
    @Override
    public void addUser(User user) {
        teacherDao.addUser(user);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> queryTeachers() {
        return teacherDao.queryTeachers();
    }

    @Override
    public Teacher queryByTeacherName(String userName) {
        return teacherDao.queryByTeacherName(userName);
    }

    @Override
    public List<Teacher> queryTeachersByEducation(String education) {
        return teacherDao.queryTeachersByEducation(education);
    }
}
