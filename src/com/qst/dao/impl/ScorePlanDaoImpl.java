package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.ScorePlanDao;
import com.qst.pojo.CoursePlan;
import com.qst.pojo.ScorePlan;
import com.qst.pojo.Student;

import java.util.List;

public class ScorePlanDaoImpl extends BaseDao implements ScorePlanDao {
    @Override
    public Student queryByStudentName(String s_name) {
        String sql="select s_id,userName,s_name,age,sex,comment,createTime,c_id from student WHERE userName=?";
        return queryForOne(Student.class,sql,s_name);
    }

    @Override
    public List<ScorePlan> queryScoreInfoPageTotal(Integer s_id) {
        String sql="(SELECT\n" +
                "course.c_name,\n" +
                "score.daily_work,\n" +
                "score.exam_results,\n" +
                "score.total_mark\n" +
                "FROM\n" +
                "course\n" +
                "INNER JOIN score ON score.course_id = course.course_id\n" +
                "WHERE\n" +
                "s_id=?)";
        return queryForList(ScorePlan.class,sql,s_id);
    }

    @Override
    public List<ScorePlan> queryScoreInfo(int pageNo, int pageSize, Integer s_id) {
        int dataNum =( pageNo-1)*pageSize;
        String sql="(SELECT\n" +
                "course.c_name,\n" +
                "score.daily_work,\n" +
                "score.exam_results,\n" +
                "score.total_mark\n" +
                "FROM\n" +
                "course\n" +
                "INNER JOIN score ON score.course_id = course.course_id\n" +
                "WHERE\n" +
                "s_id=?)"+"LIMIT "+dataNum+","+pageSize;
        return queryForList(ScorePlan.class,sql,s_id);
    }
}
