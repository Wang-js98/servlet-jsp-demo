package com.qst.service.impl;


import com.qst.dao.CoursePlanDao;
import com.qst.dao.impl.CoursePlanDaoImpl;
import com.qst.pojo.*;
import com.qst.service.CoursePlanService;

import java.util.List;

public class CoursePlanServiceImpl implements CoursePlanService {
    private CoursePlanDao coursePlanDao=new CoursePlanDaoImpl();
    @Override
    public Student queryByStudentName(String s_name) {
        return coursePlanDao.queryByStudentName(s_name);
    }

    @Override
    public Page<CoursePlan> queryCourseInfoPageTotal(Integer s_id) {
        return null;
    }

    @Override
    public Page<CoursePlan> queryCourseInfo(int pageNo, int pageSize, Integer s_id) {
        List<CoursePlan> coursePlanList = coursePlanDao.queryCourseInfoPageTotal(s_id);
        List<CoursePlan> coursePlanList1 = coursePlanDao.queryCourseInfo(pageNo,pageSize,s_id);
        int total =coursePlanList.size();
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;
        if(pageCount==0){
            pageCount=1;
        }
        Page<CoursePlan> page = new Page<CoursePlan>();
        page.setCurrentPage(pageNo);
        page.setData(coursePlanList1);
        page.setPageCount(pageCount);
        return page;
    }


}
