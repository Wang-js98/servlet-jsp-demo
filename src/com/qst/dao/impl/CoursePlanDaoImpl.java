package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.CoursePlanDao;
import com.qst.pojo.CoursePlan;
import com.qst.pojo.Student;

import java.util.List;

public class CoursePlanDaoImpl extends BaseDao implements CoursePlanDao {

    @Override
    public Student queryByStudentName(String s_name) {
        String sql="select s_id,userName,s_name,age,sex,comment,createTime,c_id from student WHERE userName=?";
        return queryForOne(Student.class,sql,s_name);
    }

    @Override
    public List<CoursePlan> queryCourseInfoPageTotal(Integer s_id) {
        String sql="(SELECT\n" +
                "course.c_name,\n" +
                "classroom.c_name c_name1,\n" +
                "teacher.t_name\n" +
                "FROM\n" +
                "(course ,\n" +
                "student ,\n" +
                "teacher_class)\n" +
                "INNER JOIN classroom ON student.c_id = classroom.c_id AND teacher_class.c_id = classroom.c_id\n" +
                "INNER JOIN teacher ON teacher.course_id = course.course_id AND teacher_class.t_id = teacher.t_id\n" +
                "WHERE s_id=?)";
        return queryForList(CoursePlan.class,sql,s_id);
    }

    @Override
    public List<CoursePlan> queryCourseInfo(int pageNo, int pageSize, Integer s_id) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="(SELECT\n" +
                "course.c_name,\n" +
                "classroom.c_name c_name1,\n" +
                "teacher.t_name\n" +
                "FROM\n" +
                "(course ,\n" +
                "student ,\n" +
                "teacher_class)\n" +
                "INNER JOIN classroom ON student.c_id = classroom.c_id AND teacher_class.c_id = classroom.c_id\n" +
                "INNER JOIN teacher ON teacher.course_id = course.course_id AND teacher_class.t_id = teacher.t_id\n" +
                "WHERE s_id=?)"+"LIMIT "+dataNum+","+pageSize;
        return queryForList(CoursePlan.class,sql,s_id);
    }
}
