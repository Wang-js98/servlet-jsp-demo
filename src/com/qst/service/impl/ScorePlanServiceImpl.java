package com.qst.service.impl;

import com.qst.dao.ScorePlanDao;
import com.qst.dao.impl.ScorePlanDaoImpl;
import com.qst.pojo.CoursePlan;
import com.qst.pojo.Page;
import com.qst.pojo.ScorePlan;
import com.qst.pojo.Student;
import com.qst.service.ScorePlanService;

import java.util.List;

public class ScorePlanServiceImpl implements ScorePlanService {
    private ScorePlanDao scorePlanDao=new ScorePlanDaoImpl();
    @Override
    public Student queryByStudentName(String s_name) {
        return scorePlanDao.queryByStudentName(s_name);
    }

    @Override
    public Page<ScorePlan> queryScoreInfoPageTotal(Integer s_id) {
        return null;
    }

    @Override
    public Page<ScorePlan> queryScoreInfo(int pageNo, int pageSize, Integer s_id) {
        List<ScorePlan> scorePlanList = scorePlanDao.queryScoreInfoPageTotal(s_id);
        List<ScorePlan> scorePlanList1 = scorePlanDao.queryScoreInfo(pageNo,pageSize,s_id);
        int total =scorePlanList.size();
        int pageCount = total % Page.PAGE_SIZE == 0 ?  //判断总页数
                total / Page.PAGE_SIZE : total/ Page.PAGE_SIZE + 1;
        Page<ScorePlan> page = new Page<ScorePlan>();
        page.setCurrentPage(pageNo);
        page.setData(scorePlanList1);
        page.setPageCount(pageCount);
        return page;
    }
}
