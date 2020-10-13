<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/threebar.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userManger.css"/>
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
				   <h4>首页/用户管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form action="userServlet?action=searchUser" method="post">
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">用户名</span>
			    <input type="text" name="searchName" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
			  </div>
			  
			 <div id="input2">
		     <span id="sp1">用户类型</span>
			<select class="form-control" id="sel1" name="searchType">
			  <option value="0" disabled selected>选择用户类型</option>
			  <option value="1">学生</option>
			  <option value="3">管理员</option>
			  <option value="2">教师</option>
			 
			</select>
			</div> 
			
			<input class="btn btn-default" type="submit" value="搜索">
			
			</form>
			   </div>
			   <br /><br />
			   <div class="right-group">
				   <!-- Large modal -->
				   <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model2" >添加学生</button>

				   <div id="model2" class="modal fade bs-example-modal-lg " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
					   <div class="modal-dialog modal-lg" role="document">
						   <div class="modal-content">
							   <form action="userServlet?action=addStudent" method="post">
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
									   <div class="col-sm-10">
										   <input type="text" name="userName" class="form-control" id="inputEmail3" >
									   </div>
								   </div>
								   <br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
									   <div class="col-sm-10">
										   <input type="text" name="s_name" class="form-control" id="inputEmail3" >
									   </div>
								   </div>
								   <br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
									   <div class="col-sm-10">
										   <input type="text" name="password" class="form-control" id="inputEmail3" >
									   </div>
								   </div><br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
									   <div class="col-sm-10">
										   <input type="text" name="age" class="form-control" id="inputEmail3" >
									   </div>
								   </div><br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
									   <div class="col-sm-5">
										   <label class="radio-inline">
											   <input type="radio" name="sex" id="inlineRadio1" value="1"> 男
										   </label>
										   <label class="radio-inline">
											   <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
										   </label>

									   </div>
								   </div>
								   <br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">班级</label>
									   <div class="col-sm-10">
										   <select  name="c_id" class="form-control">
											   <c:forEach var="classr" items="${classRoom}">
											   <option  value="${classr.c_id}">${classr.c_name}</option>

											   </c:forEach>
										   </select>
									   </div>
								   </div>
								   <br />
								   <button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
							   </form>
						   </div>
					   </div>
				   </div>

				   <!-- Large modal -->
				   <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#model1">添加教师</button>

				   <div class="modal fade bs-example-modal-lg " tabindex="-1" id="model1" role="dialog" aria-labelledby="myLargeModalLabel">
					   <div class="modal-dialog modal-lg" role="document">
						   <div class="modal-content">
							   <form action="userServlet?action=addTeacher" method="post">
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
									   <div class="col-sm-10">
										   <input type="text" name="userName" class="form-control" id="inputEmail3" >
									   </div>
								   </div>
								   <br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
									   <div class="col-sm-10">
										   <input type="text" name="t_name" class="form-control" id="inputEmail3" >
									   </div>
								   </div>
								   <br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
									   <div class="col-sm-10">
										   <input type="text" name="password" class="form-control" id="inputEmail3" >
									   </div>
								   </div><br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">年龄</label>
									   <div class="col-sm-10">
										   <input type="text" name="age" class="form-control" id="inputEmail3" >
									   </div>
								   </div><br /><br /><br />
								   <div class="form-group">
									   <label for="inputEmail3"  class="col-sm-2 control-label">性别</label>
									   <div class="col-sm-5">
										   <label class="radio-inline">
											   <input type="radio" name="sex" id="inlineRadio1" value="1"> 男
										   </label>
										   <label class="radio-inline">
											   <input type="radio" name="sex" id="inlineRadio2" value="0"> 女
										   </label>

									   </div>
								   </div><br /><br /><br />

								   <div class="form-group">
									   <label for="inputEmail3" class="col-sm-2 control-label">学历</label>
									   <div class="col-sm-10">
										   <select name="education" class="form-control">
											   <option>博士</option>
											   <option>研究生</option>
											   <option>本科</option>
											   <option>大专</option>

										   </select>
									   </div>
								   </div>


								   <br /><br /><br />
								   <br />
								   <button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
							   </form>
						   </div>
					   </div>
				   </div>
			   </div>
			   <br />
			   <div class="right-group">
				   
				   <table class="table table-hover">
				     <tr>
						 <th>编号</th>
						 <th>用户名</th>
						 <th>用户类型</th>
						 <th>状态</th>
						 <th>创建时间</th>
						 <th>操作</th>
					 </tr>
					   <c:forEach var="user"   items="${result.data}"  >
						   <tr>
							   <td>${user.userId}</td>
							   <td>${user.userName}</td>
							   <td>
								   <c:if test="${user.userType == 3}">管理员</c:if>
								   <c:if test="${user.userType == 2}">教师</c:if>
								   <c:if test="${user.userType == 1}">学生</c:if>

							   </td>
							   <td>
								<c:if test="${user.status == 1}"> 启用</c:if>
								<c:if test="${user.status == 0}"> 禁用</c:if>
								   <a href="changeStatus?status=${user.status}&userId=${user.userId}" class="btn btn-default btn-sm active" role="button">切换</a>
							   </td>
							   <td>${user.creatTime }</td>
							   <td> <a href="userServlet?action=deleteUser&id=${user.userId}" class="btn btn-danger btn-sm active" role="button">删除</a></td>
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
