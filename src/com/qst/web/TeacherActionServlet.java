package com.qst.web;

import com.qst.pojo.*;
import com.qst.service.WorkPlanService;
import com.qst.service.impl.WorkPlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TeacherActionServlet extends BaseServlet{
    WorkPlanService workPlanService=new WorkPlanServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void WorkPlanPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        String t_name = user.getUserName();
        Teacher teacher=workPlanService.queryByTeacherName(t_name);
        Integer t_id=teacher.getT_id();
        Integer course_id = teacher.getCourse_id();
        Course course = workPlanService.queryCourseByTeacher(course_id);
        String courseName=course.getC_name();
        req.setAttribute("courseName",courseName);
        req.setAttribute("t_name",t_name);
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<WorkPlan> WorkPlans = workPlanService.queryWorkPlanByTeacherIda(pageNo,5,t_id);
        req.setAttribute("WorkPlans",WorkPlans);
        req.getRequestDispatcher("/pages/course.jsp").forward(req, resp);

    }


}
