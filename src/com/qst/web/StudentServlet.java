package com.qst.web;

import com.qst.pojo.Page;
import com.qst.pojo.Student;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.service.StudentService;
import com.qst.service.TeacherService;
import com.qst.service.impl.StudentServiceImpl;
import com.qst.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet{

    StudentService studentService=new StudentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void studentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<Student> page = studentService.queryStus(pageNo, 5);
        req.setAttribute("result",page);

        req.getRequestDispatcher("pages/studentManger.jsp").forward(req, resp);

    }


    protected void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s_name=req.getParameter("s_name");
        List<Student> list = studentService.searchStu(s_name);
        Page<Student> page=new Page<>();
        page.setCurrentPage(1);
        page.setPageCount(1);
        page.setData(list);
        req.setAttribute("result",page);

        req.getRequestDispatcher("pages/studentManger.jsp").forward(req, resp);

    }



}
