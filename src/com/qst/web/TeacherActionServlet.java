package com.qst.web;

import com.qst.pojo.*;
import com.qst.service.WorkPlanService;
import com.qst.service.impl.WorkPlanServiceImpl;
import com.qst.utils.WebUtils;

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

    protected void StudentComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        String t_name = user.getUserName();
        Teacher teacher=workPlanService.queryByTeacherName(t_name);
        Integer t_id=teacher.getT_id();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<StudentComment> studentCommentPage = workPlanService.queryStudentByTeacherId(pageNo,5,t_id);
        req.setAttribute("studentCommentPage",studentCommentPage);
        req.getRequestDispatcher("/pages/studentMsg.jsp").forward(req, resp);

    }
    protected void updateStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int s_id= WebUtils.parseInt(req.getParameter("s_id"),0);
        Student student=WebUtils.copyParamToBean(req.getParameterMap(),new Student());
        workPlanService.updateStudentCommentById(student,s_id);
        resp.sendRedirect(req.getContextPath()+"/teacherActionServlet?action=StudentComment&pageNo="+req.getParameter("pageNo"));

    }
}
