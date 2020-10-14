package com.qst.service;

import com.qst.pojo.*;

import java.util.List;

public interface CoursePlanService {
    //查询登录学生的所有信息
    public Student queryByStudentName(String s_name);
    //根据学生的id查找其所在的班级名称，课程名称，教师名称求总页数
    public Page<CoursePlan> queryCourseInfoPageTotal(Integer s_id);
    //根据学生的id查找其所在的班级名称，课程名称，教师名称
    public Page<CoursePlan> queryCourseInfo(int pageNo,int pageSize,Integer s_id);
}
