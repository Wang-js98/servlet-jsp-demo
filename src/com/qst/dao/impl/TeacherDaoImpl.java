package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.TeacherDao;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.pojo.WorkArrange;
import com.qst.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public int addUser(User user) {
        String sql="insert into user(userName,password,userType,status,createTime) values(?,?,?,?,now())";
        return update(sql,user.getUserName(),user.getPassword(),user.getUserType(),user.getStatus()
                );
    }

    @Override
    public int addTeacher(Teacher teacher) {
        String sql="insert into teacher(userName,t_name,age,sex,education) values(?,?,?,?,?)";
        return update(sql,teacher.getUserName(),teacher.getT_name(),teacher.getAge(),teacher.getSex(),
                teacher.getEducation());
    }

    @Override
    public List<Teacher> queryTeachers(int pageNo, int pageSize) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher limit "+dataNum+","+pageSize;
        return queryForList(Teacher.class,sql);
    }

    @Override
    public List<Teacher> queryByTeacherName(String t_name){
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE t_name=?";
        return queryForList(Teacher.class,sql,t_name);
    }

    @Override
    public List<Teacher> queryTeachersByEducation(String education) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE education=?";
        return queryForList(Teacher.class,sql,education);
    }

    @Override
    public List<Teacher> queryTeachersByTags(String t_name, String education) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE t_name=? and education=?";
        return queryForList(Teacher.class,sql,t_name,education);
    }

    @Override
    public List<WorkArrange> searchWork(int t_id) {
        String sql="SELECT\n" +
                "course.course_id,\n" +
                "course.c_name,\n" +
                "classroom.c_id,\n" +
                "classroom.c_name class_name,\n" +
                "teacher.t_id,\n" +
                "teacher.t_name\n" +
                "FROM\n" +
                "(course ,\n" +
                "classroom)\n" +
                "INNER JOIN teacher ON teacher.course_id = course.course_id\n" +
                "INNER JOIN teacher_class ON teacher_class.c_id = classroom.c_id AND teacher_class.t_id = teacher.t_id\n" +
                "WHERE\n" +
                "teacher.t_id = ?\n";
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement ps = null;
        List<WorkArrange> list=new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, t_id);
            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                WorkArrange workArrange=new WorkArrange();
                workArrange.setT_id(rs.getInt("t_id"));
                workArrange.setT_name(rs.getString("t_name"));
                workArrange.setC_id(rs.getInt("course_id"));
                workArrange.setC_name(rs.getString("c_name"));
                workArrange.setClass_id(rs.getInt("c_id"));
                workArrange.setClass_name(rs.getString("class_name"));
                list.add(workArrange);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    @Override
    public int updateTeaCourse(int t_id, int course_id) {
        String sql="update teacher set course_id=? where t_id=?";
        return update(sql,course_id,t_id);

    }

    @Override
    public int deleteTeaClass(int t_id) {
        String sql="delete from teacher_class where t_id=?";
        return update(sql,t_id);
    }

    @Override
    public int insertTeaClass(int t_id, int c_id) {
        String sql="insert into teacher_class(t_id,c_id) values(?,?)";
        return update(sql,t_id,c_id);
    }
}
