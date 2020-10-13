package com.qst.web;

import com.qst.dao.AdminDao;
import com.qst.pojo.Page;
import com.qst.pojo.Student;
import com.qst.pojo.Teacher;
import com.qst.pojo.User;
import com.qst.service.AdminService;
import com.qst.service.StudentService;
import com.qst.service.TeacherService;
import com.qst.service.impl.AdminServiceImpl;
import com.qst.service.impl.StudentServiceImpl;
import com.qst.service.impl.TeacherServiceImpl;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends BaseServlet {

    public AdminService adminService=new AdminServiceImpl();
    TeacherService teacherService=new TeacherServiceImpl();
    StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId= WebUtils.parseInt(req.getParameter("id"),0);
        adminService.deleteAdminId(userId);

        req.getRequestDispatcher("/toUserManger").forward(req,resp);
    }

    protected void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("searchName");
        int userType= WebUtils.parseInt(req.getParameter("searchType"),0);

        List<User> list = adminService.queryUserByTag(userName, userType);

        Page<User> page=new Page<>();
        page.setCurrentPage(1);
        page.setData(list);
        page.setPageCount(1);
        req.setAttribute("result",page);
        req.getRequestDispatcher("pages/userManger.jsp").forward(req, resp);
    }

    protected void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String userName=req.getParameter("userName");
       String s_name=req.getParameter("s_name");
       String password=req.getParameter("password");
       int age= Integer.parseInt(req.getParameter("age"));
       int sex= Integer.parseInt(req.getParameter("sex"));
       int c_id= Integer.parseInt(req.getParameter("c_id"));

       User user=new User();
       user.setUserName(userName);
       user.setUserType(1);
       user.setPassword(password);
       user.setStatus(1);

        Student stu = new Student();
        stu.setUserName(userName);
        stu.setS_name(s_name);
        stu.setAge(age);
        stu.setSex(sex);

        stu.setC_id(c_id);
        studentService.addStudent(user,stu);
        req.getRequestDispatcher("/toUserManger").forward(req,resp);
    }

    protected void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName=req.getParameter("userName");
        String t_name=req.getParameter("t_name");
        String password=req.getParameter("password");
        int age= Integer.parseInt(req.getParameter("age"));
        int sex= Integer.parseInt(req.getParameter("sex"));
        String education=req.getParameter("education");
        User user=new User();
        user.setUserName(userName);

        user.setUserType(2);
        user.setPassword(password);
        user.setStatus(1);

        Teacher tea = new Teacher();
        tea.setUserName(userName);
        tea.setT_name(t_name);
        tea.setAge(age);
        tea.setSex(sex);
        tea.setEducation(education);
       teacherService.addTeacher(user,tea);
        req.getRequestDispatcher("/toUserManger").forward(req,resp);
    }


    protected void updateUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
       int userId= Integer.parseInt(req.getParameter("userId"));
        adminService.updateUserName(userName,userId);
        User user=adminService.queryByUsername(userName);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        req.getRequestDispatcher("/toUserManger").forward(req, resp);
    }
    protected void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");
        String oldPwd=req.getParameter("oldPwd");
        String newPwd=req.getParameter("newPwd");
        String confirmPwd=req.getParameter("confirmPwd");
        int userId= Integer.parseInt(req.getParameter("userId"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
       if(!oldPwd.equals(user.getPassword())){
           out.print("<script>alert('原密码错误!');window.location.href='pages/index-admin.jsp'</script>");
       }else if(!confirmPwd.equals(newPwd)){
           out.print("<script>alert('两次密码不一致!');window.location.href='pages/index-admin.jsp'</script>");

       }else {
           adminService.updatePwd(newPwd,userId);
           out.print("<script>alert('修改成功，请重新登录!');window.location.href='userServlet?action=exitLogin'</script>");
       }

    }
    protected void exitLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("login.jsp");
    }
}




