package com.qst.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求参数

        //2.调用service.xxx（）处理业务
        //user.Login（）登录
        //3.根据Login（）方法返回结果判断是否成功

        //3.根据Login（）方法返回结果判断是否成功
       // if(loginUser==null){
            //登录失败
            //失败返回登录界面
            //绑定错误信息回传jsp界面
          //  req.setAttribute("msg","用户名或者密码错误!");
          //  req.setAttribute("username",username);
           // req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);

       // }else {
            //绑定登录成功的用户信息到session中
        //    req.getSession().setAttribute("user",loginUser);

            //成功     跳转到转发Login_success.html界面
          //  req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }

}




