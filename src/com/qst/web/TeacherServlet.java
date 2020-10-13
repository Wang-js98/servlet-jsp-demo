package com.qst.web;

import com.qst.pojo.*;
import com.qst.service.ClassRoomService;
import com.qst.service.CourseService;
import com.qst.service.TeacherService;
import com.qst.service.impl.ClassRoomServiceImpl;
import com.qst.service.impl.CourseServiceImpl;
import com.qst.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherServlet extends BaseServlet{

    public TeacherService teacherService=new TeacherServiceImpl();
    ClassRoomService classRoomService=new ClassRoomServiceImpl();
    CourseService courseService=new CourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void TeacherList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<Teacher> page = teacherService.queryTeachers(pageNo, 5);
        req.setAttribute("result",page);


        //跳转到教师管理页面
        req.getRequestDispatcher("pages/teacherManger.jsp").forward(req, resp);

    }
    protected void searchTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String t_name = req.getParameter("t_name");
        String education = req.getParameter("education");

        List<Teacher> list = teacherService.queryTeachersByTags(t_name,education);
        Page<Teacher> page=new Page<>();
        page.setCurrentPage(1);
        page.setPageCount(1);
        page.setData(list);
        req.setAttribute("result",page);

        //跳转到教师管理页面
        req.getRequestDispatcher("pages/teacherManger.jsp").forward(req, resp);

    }

    protected void queryWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       int t_id= Integer.parseInt(req.getParameter("t_id"));

        List<WorkArrange> list = teacherService.queryWork(t_id);
        List<ClassRoom> classRooms = classRoomService.queryClassRoom();
        List<Course> courses = courseService.queryCourse();
        req.setAttribute("classRooms",classRooms);
        req.setAttribute("works",list);
        req.setAttribute("courses",courses);

        req.getRequestDispatcher("pages/workArrange.jsp").forward(req, resp);

    }


    protected void updateWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       int t_id= Integer.parseInt(req.getParameter("t_id"));
       int course_id= Integer.parseInt(req.getParameter("radio_course"));
       String c_id[] = req.getParameterValues("checkbox_class");
       teacherService.updateWork(t_id,course_id,c_id);
        resp.sendRedirect("teacherServlet?action=TeacherList&pageNo=1");


    }



}
