package com.qst.dao;

import com.qst.pojo.*;

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
    //根据老师id查询属于该老师的学生
    public List<StudentComment> queryStudentByTeacherId(int pageNo, int pageSize, Integer t_id);
    //根据老师id查询属于该老师的学生的总页数
    public List<StudentComment> queryStudentByTeacherIdPageTotal(Integer t_id);
    //根据学生Id修改学生评语
    public int updateStudentCommentById(Student student,Integer s_id);
}
