<%--
  Created by IntelliJ IDEA.
  User: 37423
  Date: 2020-10-07
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--动态获取base--%>
<%
    String basePath=request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";

    pageContext.setAttribute("basePath",basePath);


%>

<!--写base路径永远固定相对路径跳转问题-->
<base href=" <%=basePath%>">
<head>

    <title>学生信息管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/threebar.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
</head>
<body>
<nav id="top" class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container-fluid">

        <span id="span1"><font id="font1">学生信息管理系统</font></span>
        <!-- Single button -->
        <div class="btn-group" id="btng1">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Action <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">个人信息</a></li>
                <li><a href="#">密码修改</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div id="div1">

    <div id="left">

        <div class="lf-bar"><a href="toUserManger"><font>用户管理</font></a></div>
        <div class="lf-bar"><a href="teacherServlet?action=TeacherList&pageNo=1"><font>教师管理</font></a></div>
        <div class="lf-bar"><a href="studentServlet?action=studentList&pageNo=1"><font>学生管理</font></a></div>
        <div class="lf-bar"><a href="courseServlet?action=pageCourse&pageNo=1"><font>课程管理</font></a></div>
        <div class="lf-bar"><a href="classServlet?action=pageClassRooms&pageNo=1"><font>班级管理</font></a></div>

    </div>
    <div id="right">
        <div id="rig1" class="right-group">
            <h4>首页/用户管理</h4>
        </div>

    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../js/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
