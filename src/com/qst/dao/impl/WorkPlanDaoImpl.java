package com.qst.dao.impl;

import com.qst.dao.BaseDao;
import com.qst.dao.WorkPlanDao;
import com.qst.pojo.Course;
import com.qst.pojo.Teacher;
import com.qst.pojo.WorkPlan;

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
        String sql="select c_name FROM classroom WHERE c_id in(SELECT c_id FROM teacher_class WHERE t_id=3)" +
                "LIMIT "+dataNum+","+pageSize;
        return queryForList(WorkPlan.class,sql);
    }
}
