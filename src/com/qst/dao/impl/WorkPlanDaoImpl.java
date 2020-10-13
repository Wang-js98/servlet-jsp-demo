package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.WorkPlanDao;
import com.qst.pojo.*;

import java.util.List;

public class WorkPlanDaoImpl extends BaseDao implements WorkPlanDao {
    @Override
    public Teacher queryByTeacherName(String t_name) {
        String sql="select t_id,userName,t_name,age,sex,education,course_id from teacher WHERE userName=?";
        return queryForOne(Teacher.class,sql,t_name);
    }

    @Override
    public Course queryCourseByTeacher(Integer course_id) {
        String sql="select c_name,description,createTime from course WHERE course_id=?";
        return queryForOne(Course.class,sql,course_id);
    }

    @Override
    public List<WorkPlan> queryWorkPlanByTeacherId(Integer t_id) {
        String sql="select c_name FROM classroom WHERE c_id in(SELECT c_id FROM teacher_class WHERE t_id=?)";
        return queryForList(WorkPlan.class,sql,t_id);
    }

    @Override
    public List<WorkPlan> queryWorkPlanByTeacherIda(int pageNo, int pageSize,Integer t_id) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="select c_name FROM classroom WHERE c_id in(SELECT c_id FROM teacher_class WHERE t_id=?)" +
                "LIMIT "+dataNum+","+pageSize;
        return queryForList(WorkPlan.class,sql,t_id);
    }

    @Override
    public List<StudentComment> queryStudentByTeacherId(int pageNo, int pageSize, Integer t_id) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="(SELECT\n" +
                "student.s_id,\n" +
                "student.s_name,\n" +
                "student.userName,\n" +
                "student.age,\n" +
                "student.sex,\n" +
                "student.`comment`,\n" +
                "student.createTime,\n" +
                "student.c_id,\n" +
                "teacher.t_id,\n" +
                "classroom.c_id,\n" +
                "classroom.c_name\n" +
                "FROM\n" +
                "(student ,\n" +
                "teacher)\n" +
                "INNER JOIN classroom ON student.c_id = classroom.c_id\n" +
                "INNER JOIN teacher_class ON teacher_class.c_id = classroom.c_id AND teacher_class.t_id = teacher.t_id\n" +
                "WHERE\n" +
                "teacher.t_id = ?)"+"LIMIT "+dataNum+","+pageSize;
        return queryForList(StudentComment.class,sql,t_id);
    }

    @Override
    public List<StudentComment> queryStudentByTeacherIdPageTotal(Integer t_id) {
        String sql="(SELECT\n" +
                "student.s_id,\n" +
                "student.s_name,\n" +
                "student.userName,\n" +
                "student.age,\n" +
                "student.sex,\n" +
                "student.`comment`,\n" +
                "student.createTime,\n" +
                "student.c_id,\n" +
                "teacher.t_id,\n" +
                "classroom.c_id,\n" +
                "classroom.c_name\n" +
                "FROM\n" +
                "(student ,\n" +
                "teacher)\n" +
                "INNER JOIN classroom ON student.c_id = classroom.c_id\n" +
                "INNER JOIN teacher_class ON teacher_class.c_id = classroom.c_id AND teacher_class.t_id = teacher.t_id\n" +
                "WHERE\n" +
                "teacher.t_id = ?)";
        return queryForList(StudentComment.class,sql,t_id);
    }

    @Override
    public int updateStudentCommentById(Student student, Integer s_id) {
        String sql="update student set `comment`=? where s_id=?";
        return update(sql,student.getComment(),s_id);
    }
}
