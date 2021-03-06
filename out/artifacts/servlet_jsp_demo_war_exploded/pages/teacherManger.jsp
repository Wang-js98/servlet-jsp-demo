<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/threebar.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/teacherManger.css"/>
		<title></title>
		
	</head>
	<body>
		<nav id="top" class="navbar navbar-default navbar-fixed-top navbar-inverse">
		  <div class="container-fluid">
			  
		    <span id="span1"><font id="font1">学生信息管理系统</font></span>
			<!-- Single button -->
			<div class="btn-group" id="btng1">
			  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				  ${user.userName} <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu">
				  <li><a data-toggle="modal" data-target="#personMsg" href="#">个人信息</a></li>
				  <li><a data-toggle="modal" data-target="#pwdMsg" href="#">密码修改</a></li>
				  <li role="separator" class="divider"></li>
				  <li><a href="userServlet?action=exitLogin">退出</a></li>
			  </ul>
			</div>
		  </div>
		</nav>
		<%--个人信息模态框--%>
		<div class="modal fade bs-example-modal-lg" tabindex="-1" id="personMsg" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<h2>个人信息</h2>
					<form action="userServlet?action=updateUserName" method="post">
						<input type="hidden" value="${user.userId}" name="userId">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" name="userName" class="form-control" id="inputEmail3" value="${user.userName}">
							</div>
						</div>
						<br /><br /><br />

						<button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade bs-example-modal-lg" tabindex="-1" id="pwdMsg" role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<h2>修改密码</h2>
					<form action="userServlet?action=updatePwd" method="post">
						<input type="hidden" value="${user.userId}" name="userId">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-10">
								<input type="password" name="oldPwd" class="form-control" id="inputEmail3" >
							</div>
						</div><br><br><br>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="password" name="newPwd" class="form-control" id="inputEmail3" >
							</div>
						</div><br><br><br>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" name="confirmPwd" class="form-control" id="inputEmail3" >
							</div>
						</div>
						<br /><br /><br />

						<button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
					</form>
				</div>
			</div>
		</div>
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
				   <h4>首页/教师管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form action="teacherServlet?action=searchTeacher" method="post">
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">教师姓名</span>
			    <input type="text" class="form-control" name="t_name" placeholder="教师姓名" aria-describedby="basic-addon1">
			  </div>
			  
			 <div id="input2">
		     <span id="sp1">教师学历</span>
			<select class="form-control" id="sel1" name="education">
<%--		不要设置disabled属性，不然后端取不到这个值，会为null，null强转成int变为0		--%>
			  <option value="default" >选择学历</option>
			  <option value="博士">博士</option>
			  <option value="研究生">研究生</option>
			  <option value="本科">本科</option>
			  <option value="高中">高中</option>
			 
			</select>
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
						 <th>学历</th>
						 <th>工作安排</th>
					 </tr>
					   <c:forEach items="${result.data}" var="tea">
					 <tr>
						 <td>${tea.t_id}</td>
						 <td>${tea.t_name}</td>
						 <td>${tea.age}</td>
						 <td>
							 <c:if test="${tea.sex == 1}">男</c:if>
							 <c:if test="${tea.sex == 0}">女</c:if>
						 </td>
						 <td>${tea.education}</td>
						 <td> 
						 
						 <!-- Large modal -->
							 <a href="teacherServlet?action=queryWork&t_id=${tea.t_id}" class="btn btn-primary btn-xs active" role="button">工作安排</a>
						 </td>
					 </tr>
					   </c:forEach>

				   </table>
				   <br> 共${result.pageCount }页  当前第${result.currentPage }页
				   <c:if test="${result.currentPage != 1}">
					   <a href="teacherServlet?action=TeacherList&pageNo=1" >首页</a>
					   <a href="teacherServlet?action=TeacherList&pageNo=${result.currentPage-1 }" >上一页</a>
				   </c:if>


				   <c:if test="${result.currentPage != result.pageCount}">
					   <a href="teacherServlet?action=TeacherList&pageNo=${result.currentPage+1 }" >下一页</a>
					   <a href="teacherServlet?action=TeacherList&pageNo=${result.pageCount }" >尾页</a>
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
