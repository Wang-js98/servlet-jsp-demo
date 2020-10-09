package com.qst.web;

import com.qst.pojo.Student;
import com.qst.service.StudentService;
import com.qst.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet{

    public StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void StudentList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过CourseService查询全部课程
        List<Student> students=studentService.queryStudents();
        //把全部图书保存到request域当中
        req.setAttribute("students",students);

        //请求转发到/manager/bookServlet?action=list界面
        req.getRequestDispatcher("/pages/studentManger.jsp").forward(req,resp);

    }

}
