package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.TeacherDao;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public int addUser(User user) {
        String sql="insert into user(userName,password,userType,status,createTime) values(?,?,?,?,?)";
        return update(sql,user.getUserName(),user.getPassword(),2,user.getStatus(),
                user.getCreatTime());
    }

    @Override
    public int addTeacher(Teacher teacher) {
        String sql="insert into teacher(userName,t_name,age,sex,education,course_id) values(?,?,?,?,?,?)";
        return update(sql,teacher.getUserName(),teacher.getT_name(),teacher.getAge(),teacher.getSex(),
                teacher.getEducation(),teacher.getCourse_id());
    }

    @Override
    public List<Teacher> queryTeachers() {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher";
        return queryForList(Teacher.class,sql);
    }

    @Override
    public Teacher queryByTeacherName(String userName) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE userName=?";
        return queryForOne(Teacher.class,sql,userName);
    }

    @Override
    public List<Teacher> queryTeachersByEducation(String education) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE education=?";
        return queryForList(Teacher.class,sql,education);
    }
}
