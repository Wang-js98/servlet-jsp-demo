<%--
  Created by IntelliJ IDEA.
  User: 37423
  Date: 2020-10-07
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <title>Title</title>
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
        <div class="lf-bar"><a href="courseServlet?action=CourseList"><font>课程管理</font></a></div>
        <div class="lf-bar"><a><font>班级管理</font></a></div>

    </div>
    <div id="right">
        <div id="rig1" class="right-group">
            <h4>工作安排</h4>
        </div>

        <div class="right-group">
            <form action="teacherServlet?action=updateWork" method="post">

                选择课程<c:forEach items="${courses}" var="course">
                <label class="radio-inline">

                    <input type="radio" name="radio_course" value="${course.course_id}" id="inlineRadio1"
                    <c:set var="s" value="false" />
                    <c:forEach var="work" items="${works}">
                      <c:set var="t_id" value="${work.t_id}"></c:set>
                      <c:if test="${work.c_name==course.c_name}">
                        <c:set var="s" value="true" />
                      </c:if>
                    </c:forEach>
                    <c:if test="${s==true}">checked="checked"</c:if>
                    > ${course.c_name}
                </label></c:forEach>
                <input type="hidden" name="t_id" value="${t_id}">
                <br /><br />

                选择班级<c:forEach items="${classRooms}" var="classRoom">
                <label class="checkbox-inline">
                    <input type="checkbox" id="inlineCheckbox1" name="checkbox_class"  value="${classRoom.c_id}"
                        <c:set var="b" value="false" />
                    <c:forEach var="work" items="${works}">
                    <c:if test="${work.class_name==classRoom.c_name}">
                        <c:set var="b" value="true" />
                    </c:if>
                    </c:forEach>
                     <c:if test="${b==true}">checked="checked"</c:if>
                    > ${classRoom.c_name}
                </label>
                </c:forEach>

                <br /><br />
                <input class="btn btn-primary btn-sm " type="submit" value="保存">&nbsp;
                <input class="btn btn-primary btn-sm " type="reset" value="重置">
            </form>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../js/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
