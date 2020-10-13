package com.qst.controller;

import com.qst.pojo.ClassRoom;
import com.qst.pojo.Page;
import com.qst.pojo.User;
import com.qst.service.AdminService;
import com.qst.service.ClassRoomService;
import com.qst.service.impl.AdminServiceImpl;
import com.qst.service.impl.ClassRoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserPagecontroller extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<User> page = adminService.queryUsers(pageNo, 5);
        req.setAttribute("result",page);


        //跳转到用户管理页面
        req.getRequestDispatcher("pages/userManger.jsp").forward(req, resp);
        //resp.sendRedirect("login.jsp");
    }
}
