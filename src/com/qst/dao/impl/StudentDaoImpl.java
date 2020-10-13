package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.StudentDao;
import com.qst.pojo.Student;
import com.qst.pojo.User;

import java.util.List;


public class StudentDaoImpl extends BaseDao implements StudentDao {



    @Override
    public int addStudent(Student student) {
        String sql="insert into student(userName,s_name,age,sex,createTime,c_id) values(?,?,?,?,now(),?)";
        return update(sql,student.getUserName(),student.getS_name(),student.getAge(),student.getSex(),
                student.getC_id()  );
    }


    @Override
    public List<Student> queryByStudentName(String s_name) {
        String sql="select * from student where s_name = ?";
        return queryForList(Student.class,sql,s_name);
    }

    @Override
    public List<Student> queryStus(int pageNo, int pageSize) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="select * from student limit "+dataNum+","+pageSize;
        return queryForList(Student.class,sql);
    }
}
