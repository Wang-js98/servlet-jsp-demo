<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/threebar.css"/>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
	<link rel="stylesheet" type="text/css" href="css/courseManger.css"/>
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
		<div class="lf-bar"><a href="studentServlet?action=StudentList"><font>学生管理</font></a></div>
		<div class="lf-bar"><a href="courseServlet?action=pageCourse&pageNo=1"><font>课程管理</font></a></div>
		<div class="lf-bar"><a href="classServlet?action=pageClassRooms&pageNo=1"><font>班级管理</font></a></div>

	</div>
	<div id="right">
		<div id="rig1" class="right-group">
			<h4>首页/课程管理</h4>
		</div>
		<br />
		<div id="rig2" class="right-group">
			<h2>搜索信息</h2>
			<form action="courseServlet?action=CourseQueryByName" method="post">
				<div class="input-group" id="input1">
					<span class="input-group-addon" id="basic-addon1">课程名称</span>
					<input type="text" class="form-control" placeholder="课程名称" name="CourseName" aria-describedby="basic-addon1">
				</div>

				<input class="btn btn-default" type="submit" value="搜索">${requestScope.msg}

			</form>
			<a href="#" class="btn btn-primary btn-sm active" role="button">添加课程</a>
		</div>
		<br /><br />


		<div class="right-group">

			<table class="table table-hover">
				<tr>
					<th>编号</th>
					<th>课程名称</th>
					<th>课程备注</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.courses.data}"  var="courses">
				<tr>

					<td>${courses.course_id}</td>
					<td>${courses.c_name}</td>
					<td>${courses.description}</td>
					<td>${courses.createTime}</td>

					<td>
						<a href="courseServlet?action=deleteCourseById&id=${courses.course_id}&pageNo=${requestScope.courses.pageCount}" class="btn btn-danger btn-sm active" role="button">删除</a>
						<!-- Large modal -->
						<button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">编辑</button>


					</td>
				</tr>
				</c:forEach>
				<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal">
					<div class="modal-dialog modal-lg" role="document">
						<div class="modal-content">
							<h2>课程管理</h2>
							<form action="courseServlet?action=updateCourse&pageNo=${requestScope.courses.pageCount}" method="post">
								<input type="hidden" id="hidden1" name="course_id">
								<%--<input type="hidden" id="hidden2" name="createTime">--%>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">课程名称</label>
									<div class="col-sm-10">
										<input type="text" value="" name="c_name" class="form-control" id="c_name" >
									</div>
								</div>
								<br /><br /><br />
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">课程备注</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="3" id="description" name="description"></textarea>
									</div>
								</div><br /><br /><br /><br />
								<button type="submit" class="btn btn-primary btn-xs btn-block" >保存</button>
							</form>
						</div>
					</div>
				</div>
			</table>
			<br> 共${courses.pageCount }页  当前第${courses.currentPage }页
			<c:if test="${courses.currentPage != 1}">
				<a href="courseServlet?action=pageCourse&pageNo=1" >首页</a>
				<a href="courseServlet?action=pageCourse&pageNo=${courses.currentPage-1 }" >上一页</a>
			</c:if>


			<c:if test="${courses.currentPage != courses.pageCount}">
				<a href="courseServlet?action=pageCourse&pageNo=${courses.currentPage+1 }" >下一页</a>
				<a href="courseServlet?action=pageCourse&pageNo=${courses.pageCount }" >尾页</a>
			</c:if>
		</div>

	</div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
<script>
	$('#myModal').on('show.bs.modal', function (e) {
		var btnThis = $(e.relatedTarget); //触发事件的按钮
		var modal = $(this);  //当前模态框
		var c_id = btnThis.closest('tr').find('td').eq(0).text();  //获取tr下第一个td的值(id)
		var c_name = btnThis.closest('tr').find('td').eq(1).text();//获取tr下第二个td的值(name)
		var description = btnThis.closest('tr').find('td').eq(2).text();//获取tr下第三个td的值(description)
		//var createTime = btnThis.closest('tr').find('td').eq(3).text();//获取tr下第三个td的值(createTime)
		modal.find('#description').val(description); //给模态框中的元素赋值
		modal.find('#c_name').val(c_name);
		modal.find('#hidden1').val(c_id);
		//modal.find('#hidden2').val(createTime);
	})
</script>
</body>
</html>
