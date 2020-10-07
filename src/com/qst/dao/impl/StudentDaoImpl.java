package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.StudentDao;
import com.qst.pojo.Student;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;

import java.util.List;


public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public int addUser(User user) {
        String sql="insert into user(userName,password,userType,status,createTime) values(?,?,?,?,?)";
        return update(sql,user.getUserName(),user.getPassword(),1,user.getStatus(),
                user.getCreatTime());
    }

    @Override
    public int addStudent(Student student) {
        String sql="insert into student(userName,s_name,age,sex,comment,createTime,c_id) values(?,?,?,?,?,?,?)";
        return update(sql,student.getUserName(),student.getS_name(),student.getAge(),student.getSex(),student.getComment()
                ,student.getCreateTime(),student.getC_id());
    }

    @Override
    public List<Student> queryStudents() {
        String sql="select s_id,userName,s_name,age,sex,comment,createTime,c_id from student";
        return queryForList(Student.class,sql);
    }

    @Override
    public List<Student> queryByStudentName(String userName) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE userName=?";
        //return queryForOne(Student.class,sql,userName);
        return null;
    }

}
