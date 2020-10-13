package com.qst.controller;

import com.qst.service.AdminService;
import com.qst.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserStatusChange extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId= Integer.parseInt(req.getParameter("userId"));
        int status= Integer.parseInt(req.getParameter("status"));
        adminService.userStatus(status,userId);
        req.getRequestDispatcher("/toUserManger").forward(req,resp);
    }
}
