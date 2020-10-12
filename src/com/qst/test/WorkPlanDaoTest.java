package com.qst.test;

import com.qst.dao.WorkPlanDao;
import com.qst.dao.impl.WorkPlanDaoImpl;
import com.qst.pojo.WorkPlan;
import org.junit.Test;

public class WorkPlanDaoTest {

    WorkPlanDao workPlanDao=new WorkPlanDaoImpl();
    @Test
    public void queryWorkPlanByTeacherId() {
        for (WorkPlan queryWorkPlanByTeacherId:workPlanDao.queryWorkPlanByTeacherId(3)){
            System.out.println(queryWorkPlanByTeacherId);
        }

    }
}