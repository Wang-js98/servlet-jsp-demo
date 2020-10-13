<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/threebar.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentManger.css"/>
		<title></title>
		
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
			   <div class="lf-bar"><a><font>用户管理</font></a></div>
			   <div class="lf-bar"><a><font>教师管理</font></a></div>
			   <div class="lf-bar"><a><font>学生管理</font></a></div>
			   <div class="lf-bar"><a><font>课程管理</font></a></div>
			   <div class="lf-bar"><a><font>班级管理</font></a></div>
			   
		  </div>
		  <div id="right">
			   <div id="rig1" class="right-group">
				   <h4>首页/学生管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form action="studentServlet?action=searchStudent" method="post">
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">学生姓名</span>
			    <input type="text" name="s_name" class="form-control" placeholder="学生姓名" aria-describedby="basic-addon1">
			  </div>
			  
			
			<input class="btn btn-default" type="submit" value="搜索">
			
			</form>
			   </div>
			   <br /><br />
			 
			  
			   <div class="right-group">
				   
				   <table class="table table-hover">
				     <tr>
						 <th>编号</th>
						 <th>姓名</th>
						 <th>年龄</th>
						 <th>性别</th>
						 <th>成绩管理</th>
					 </tr>
					   <c:forEach var="stus" items="${result.data}">
					 <tr>
						 <td>${stus.s_id}</td>
						 <td>${stus.s_name}</td>
						 <td>${stus.age}</td>
						 <td>
							<c:if test="${stus.sex == 1}">男</c:if>
						    <c:if test="${stus.sex == 0}">女</c:if>
						 </td>
						
					 </tr>
					   </c:forEach>

				   </table>
				   <br> 共${result.pageCount }页  当前第${result.currentPage }页
				   <c:if test="${result.currentPage != 1}">
					   <a href="changePage?pageNo=1" >首页</a>
					   <a href="changePage?pageNo=${result.currentPage-1 }" >上一页</a>
				   </c:if>


				   <c:if test="${result.currentPage != result.pageCount}">
					   <a href="changePage?pageNo=${result.currentPage+1 }" >下一页</a>
					   <a href="changePage?pageNo=${result.pageCount }" >尾页</a>
				   </c:if>
			   </div>
			   
		  </div>
		</div>
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>
