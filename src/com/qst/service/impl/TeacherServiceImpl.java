package com.qst.service.impl;

import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    TeacherService teacherService=new TeacherServiceImpl();
    @Override
    public void addUser(User user) {
        teacherService.addUser(user);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherService.addTeacher(teacher);
    }
}
