package com.qst.controller.jump;

import com.qst.pojo.Page;
import com.qst.pojo.User;
import com.qst.service.AdminService;
import com.qst.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToUserManger extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<User> page = adminService.queryUsers(1, 5);
        req.setAttribute("result",page);

        //跳转到用户管理页面
        req.getRequestDispatcher("pages/userManger.jsp").forward(req, resp);
        //resp.sendRedirect("login.jsp");
    }
}
