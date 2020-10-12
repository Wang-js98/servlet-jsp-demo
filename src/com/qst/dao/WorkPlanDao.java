package com.qst.dao;

import com.qst.pojo.Course;
import com.qst.pojo.Teacher;
import com.qst.pojo.WorkPlan;

import java.util.List;

public interface WorkPlanDao {
    //查询登录老师的所有信息
    public Teacher queryByTeacherName(String t_name);
    //根据查出的老师id再查老师所教的课程
    public Course queryCourseByTeacher(Integer course_id);
    //根据老师id老师所需要教学的班级id
    public List<WorkPlan> queryWorkPlanByTeacherId(Integer t_id);
    //分页查询根据老师id老师所需要教学的班级id
    public List<WorkPlan> queryWorkPlanByTeacherIda(int pageNo, int pageSize,Integer t_id);


}
