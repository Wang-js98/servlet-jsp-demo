package com.qst.dao;


import com.qst.pojo.CoursePlan;
import com.qst.pojo.ScorePlan;
import com.qst.pojo.Student;

import java.util.List;

public interface ScorePlanDao {
    //查询登录学生的所有信息
    public Student queryByStudentName(String s_name);
    //根据学生的id查找其所持有的课程成绩，课程名称求总页数
    public List<ScorePlan> queryScoreInfoPageTotal(Integer s_id);
    //根据学生的id查找其所持有的课程成绩，课程名称
    public List<ScorePlan> queryScoreInfo(int pageNo,int pageSize,Integer s_id);
}
