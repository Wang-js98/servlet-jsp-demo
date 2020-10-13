<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentMsg.css"/>
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
			  <div class="lf-bar"><a href="teacherActionServlet?action=WorkPlanPage&pageNo=1"><font>工作安排</font></a></div>
			  <div class="lf-bar"><a href="teacherActionServlet?action=StudentComment&pageNo=1"><font>学生信息</font></a></div>
			   
		  </div>
		  <div id="right">
			   <div id="rig1" class="right-group">
				   <h4>首页/学生信息</h4>
			   </div>
			   <br />
			 
			   <br /><br />
			 
			  
			   <div class="right-group">
				   
				   <table class="table table-hover">
				     <tr>
						 <th>编号</th>
						 <th>姓名</th>
						 <th>年龄</th>
						 <th>性别</th>
						 <th>所在班级</th>
						 <th>学生评价</th>
					 </tr>
					   <c:forEach items="${requestScope.studentCommentPage.data}" var="data">
					 <tr>
						 <td>${data.s_id}</td>
						 <td>${data.s_name}</td>
						 <td>${data.age}</td>
						 <td>${data.sex}</td>
						 <td>${data.c_name}</td>
						 <td>${data.comment}</td>
						 <td> 
						 
						 <!-- Large modal -->
						 <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">学生评价</button>

						 </td>
						 </c:forEach>
						 <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal">
							 <div class="modal-dialog modal-lg" role="document">
								 <div class="modal-content">
									 <h2>学生评价</h2>
									 <form action="teacherActionServlet?action=updateStudentById&pageNo=${requestScope.studentCommentPage.currentPage}" method="post">
										 <input type="hidden" id="hidden1" name="s_id">
										 <div class="form-group">
											 <label for="inputEmail3" class="col-sm-2 control-label">学生评语</label>
											 <div class="col-sm-10">
												 <textarea class="form-control" rows="3" id="comment" name="comment"></textarea>
											 </div>
										 </div>
										 <br /><br /><br /><br /><br />
										 <button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
									 </form>
								 </div>
							 </div>
						 </div>
					 </tr>
				   </table>
				   <br> 共${requestScope.studentCommentPage.pageCount }页  当前第${requestScope.studentCommentPage.currentPage}页
				   <c:if test="${requestScope.studentCommentPage.currentPage != 1}">
					   <a href="teacherActionServlet?action=StudentComment&pageNo=1" >首页</a>
					   <a href="teacherActionServlet?action=StudentComment&pageNo=${requestScope.studentCommentPage.currentPage-1 }" >上一页</a>
				   </c:if>


				   <c:if test="${requestScope.studentCommentPage.currentPage != requestScope.studentCommentPage.pageCount}">
					   <a href="teacherActionServlet?action=StudentComment&pageNo=${requestScope.studentCommentPage.currentPage+1 }" >下一页</a>
					   <a href="teacherActionServlet?action=StudentComment&pageNo=${requestScope.studentCommentPage.pageCount }" >尾页</a>
				   </c:if>
			   </div>
			   
		  </div>
		</div>
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<script>
			$('#myModal').on('show.bs.modal', function (e) {
				var btnThis = $(e.relatedTarget); //触发事件的按钮
				var modal = $(this);  //当前模态框
				var s_id = btnThis.closest('tr').find('td').eq(0).text();  //获取tr下第一个td的值(id)
				var comment = btnThis.closest('tr').find('td').eq(5).text();//获取tr下第二个td的值(name)
				modal.find('#comment').val(comment);
				modal.find('#hidden1').val(s_id);
				//modal.find('#hidden2').val(createTime);
			})
		</script>
	</body>
</html>
