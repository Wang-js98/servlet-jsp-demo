package com.qst.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res =(HttpServletResponse) servletResponse;
        Object user = req.getSession().getAttribute("user");
        //获取请求界面的路径
        String a=req.getRequestURI();
        if (user==null) {
            //用户没有登录
            res.sendRedirect("/servlet_jsp_demo/");
            req.setAttribute("msg","请先登录后在进行该操作");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
