package com.qst.web;

import com.qst.pojo.*;
import com.qst.service.CoursePlanService;
import com.qst.service.impl.CoursePlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CoursePlanServlet extends BaseServlet{
    CoursePlanService coursePlanService=new CoursePlanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void CoursePlanPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        User user = (User) req.getSession().getAttribute("user");
        String s_name=user.getUserName();
        Student student=coursePlanService.queryByStudentName(s_name);

        Integer s_id=student.getS_id();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<CoursePlan> coursePlanPages = coursePlanService.queryCourseInfo(pageNo, 5, s_id);
        req.setAttribute("coursePlanPages",coursePlanPages);
        req.getRequestDispatcher("pages/course-stu.jsp").forward(req, resp);


    }
}
