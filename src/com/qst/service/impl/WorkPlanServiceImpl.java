package com.qst.service.impl;

import com.qst.dao.WorkPlanDao;
import com.qst.dao.impl.WorkPlanDaoImpl;
import com.qst.pojo.Course;
import com.qst.pojo.Page;
import com.qst.pojo.Teacher;
import com.qst.pojo.WorkPlan;
import com.qst.service.WorkPlanService;

import java.util.List;

public class WorkPlanServiceImpl implements WorkPlanService {
    WorkPlanDao workPlanDao=new WorkPlanDaoImpl();
    @Override
    public Teacher queryByTeacherName(String t_name) {
        return workPlanDao.queryByTeacherName(t_name);
    }

    @Override
    public Course queryCourseByTeacher(Integer course_id) {
        return workPlanDao.queryCourseByTeacher(course_id);
    }

    @Override
    public Page<WorkPlan> queryWorkPlanByTeacherIda(int pageNo, int pageSize,Integer t_id) {
        List<WorkPlan> workPlanList = workPlanDao.queryWorkPlanByTeacherId(t_id);
        List<WorkPlan> workPlanList1 = workPlanDao.queryWorkPlanByTeacherIda(pageNo,pageSize,t_id);
        int total =workPlanList.size();
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;
        Page<WorkPlan> page = new Page<WorkPlan>();
        page.setCurrentPage(1);
        page.setData(workPlanList1);
        page.setPageCount(pageCount);
        return page;
    }
    @Override
    public Page<WorkPlan> queryWorkPlanByTeacherId(Integer t_id) {
        return null;
    }
}
