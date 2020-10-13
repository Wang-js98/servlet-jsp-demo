package com.qst.test;

import com.qst.dao.WorkPlanDao;
import com.qst.dao.impl.WorkPlanDaoImpl;

import com.qst.pojo.StudentComment;
import org.junit.Test;

public class WorkPlanDaoTest {

   private WorkPlanDao workPlanDao=new WorkPlanDaoImpl();
    @Test
    public void queryStudentByTeacherId() {
        for (StudentComment StudentComment:workPlanDao.queryStudentByTeacherId(1,10,3)){
            System.out.println(StudentComment);
        }
    }

}