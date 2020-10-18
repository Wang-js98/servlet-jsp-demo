package com.qst.controller;


import com.qst.pojo.User;
import com.qst.service.AdminService;
import com.qst.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登录
public class LoginController extends HttpServlet {

    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收中文
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        //接收前端用户数据
        String val=req.getParameter("checks");  //用户输入的验证码
        //实际验证码
        String confirmVal= (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        System.out.println(confirmVal+"---------");
        System.out.println(val+"---------");
        String name = req.getParameter("userName");
        String pwd = req.getParameter("password");
        User user = adminService.queryByUsername(name);
        if(user == null || !(user.getPassword().equals(pwd))){
            req.setAttribute("loginmsg","用户名或密码错误");
            //转发
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else if(!confirmVal.equals(val)){
            req.setAttribute("loginmsg","验证码不正确");
            //转发
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else if(user.getStatus()==0){
            req.setAttribute("loginmsg","该账户已被禁用");
            //转发
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else{

            session.setAttribute("user", user);

          if(user.getUserType()==3){
              req.getRequestDispatcher("pages/index-admin.jsp").forward(req, resp);
          }else if(user.getUserType()==2){
              req.getRequestDispatcher("pages/index-teacher.jsp").forward(req, resp);
          }else{
              req.getRequestDispatcher("pages/index-student.jsp").forward(req, resp);
          }

        }

    }
}
