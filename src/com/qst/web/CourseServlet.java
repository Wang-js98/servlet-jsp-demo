package com.qst.web;

import com.qst.pojo.Course;
import com.qst.service.CourseService;
import com.qst.service.impl.CourseServiceImpl;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseServlet extends BaseServlet{

    public CourseService courseService=new CourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void CourseList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过CourseService查询全部课程
        List<Course> courses=courseService.queryCourse();
        //把全部图书保存到request域当中
        req.setAttribute("courses",courses);

        //请求转发到/manager/bookServlet?action=list界面
        req.getRequestDispatcher("/pages/courseManger.jsp").forward(req,resp);

    }

    protected void deleteCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数图书的id，图书编程
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        //2.调用bookService.delete（id）方法
        courseService.deleteCourseById(id);
        //3.重定向返回到图书列表管理界面
        req.getRequestDispatcher("/courseServlet?action=CourseList").forward(req,resp);
    }

    protected void CourseQueryByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取要查询的课程名

        String CourseName=req.getParameter("CourseName");
        //通过CourseService查询全部课程
        List<Course> courses=courseService.queryByCourseName(CourseName);
        if(courses.size()==0){
            //没有查到该课程
            req.setAttribute("msg","该课程不存在!");
            //请求转发到/pages/courseManger.jsp
            req.getRequestDispatcher("/pages/courseManger.jsp").forward(req,resp);
        }else{
            //把全部图书保存到request域当中
            req.setAttribute("courses",courses);
            //请求转发到/pages/courseManger.jsp
            req.getRequestDispatcher("/pages/courseManger.jsp").forward(req,resp);
        }
    }


    protected void updateCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要修改的课程
        Course course=WebUtils.copyParamToBean(req.getParameterMap(),new Course());

        //调用修改课程的方法
        courseService.updateCourse(course);
        //请求转发到/pages/courseManger.jsp
        req.getRequestDispatcher("/courseServlet?action=CourseList").forward(req,resp);
    }


}
