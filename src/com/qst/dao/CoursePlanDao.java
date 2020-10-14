package com.qst.dao;


import com.qst.pojo.CoursePlan;
import com.qst.pojo.Student;

import java.util.List;

public interface CoursePlanDao {
    //查询登录学生的所有信息
    public Student queryByStudentName(String s_name);
    //根据学生的id查找其所在的班级名称，课程名称，教师名称求总页数
    public List<CoursePlan> queryCourseInfoPageTotal(Integer s_id);
    //根据学生的id查找其所在的班级名称，课程名称，教师名称
    public List<CoursePlan> queryCourseInfo(int pageNo,int pageSize,Integer s_id);
}
