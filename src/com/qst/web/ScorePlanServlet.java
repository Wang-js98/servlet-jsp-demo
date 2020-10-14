package com.qst.web;

import com.qst.pojo.*;
import com.qst.service.ScorePlanService;
import com.qst.service.impl.ScorePlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ScorePlanServlet extends BaseServlet{
    ScorePlanService scorePlanService=new ScorePlanServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void ScorePlanPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        User user = (User) req.getSession().getAttribute("user");
        String s_name=user.getUserName();
        Student student=scorePlanService.queryByStudentName(s_name);
        Integer s_id=student.getS_id();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<ScorePlan> scorePlanPages = scorePlanService.queryScoreInfo(pageNo, 5, s_id);
        req.setAttribute("scorePlanPages",scorePlanPages);
        req.getRequestDispatcher("/pages/score.jsp").forward(req, resp);
    }
}
