package com.qst.web;

import com.qst.pojo.ClassRoom;
import com.qst.pojo.Course;
import com.qst.pojo.Page;
import com.qst.service.ClassRoomService;
import com.qst.service.impl.ClassRoomServiceImpl;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClassServlet extends BaseServlet{
    public ClassRoomService classRoomService=new ClassRoomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void pageClassRooms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<ClassRoom> classRooms = classRoomService.queryClassRoom(pageNo, 5);
        req.setAttribute("classRooms",classRooms);

        //跳转到班级管理页面
        req.getRequestDispatcher("/pages/classManger.jsp").forward(req, resp);
    }

    protected void updateClassRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassRoom classRoom = WebUtils.copyParamToBean(req.getParameterMap(), new ClassRoom());
        classRoomService.updateClassRoom(classRoom);
        resp.sendRedirect(req.getContextPath()+"/classServlet?action=pageClassRooms&pageNo="+req.getParameter("pageNo"));
    }

    protected void deleteClassRoomById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("c_id"),0);
        classRoomService.deleteClassroomById(id);
        resp.sendRedirect(req.getContextPath()+"/classServlet?action=pageClassRooms&pageNo="+req.getParameter("pageNo"));
    }

    protected void queryClassRoomByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classRoomName =req.getParameter("classRoomName");
        Page<ClassRoom> classRooms = classRoomService.queryClassRoomByName(classRoomName);
        if(classRooms.getData().size()==0){
            req.setAttribute("msg","您搜索的班级不存在");
            req.getRequestDispatcher("/pages/classManger.jsp").forward(req, resp);
        }else {
            req.setAttribute("classRooms",classRooms);
            req.getRequestDispatcher("/pages/classManger.jsp").forward(req, resp);
        }


    }
    protected void addClassRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String class_name = req.getParameter("class_name");
        ClassRoom classRoom=new ClassRoom();
        classRoom.setC_name(class_name);
        classRoomService.addClassRoom(classRoom);
        req.getRequestDispatcher("classServlet?action=pageClassRooms&pageNo=1").forward(req, resp);
    }

}
