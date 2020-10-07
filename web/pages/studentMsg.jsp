<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
			  <div class="lf-bar"><a><font>工作安排</font></a></div>
			  
			  <div class="lf-bar"><a><font>学生信息</font></a></div>
			   
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
					 <tr>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td> 
						 
						 <!-- Large modal -->
						 <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">学生评价</button>
						 
						 <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
						   <div class="modal-dialog modal-lg" role="document">
						     <div class="modal-content">
								 <h2>学生评价</h2>
						       <form>
								 <div class="form-group">
								    <label for="inputEmail3" class="col-sm-2 control-label">学生评语</label>
								    <div class="col-sm-10">
								     <textarea class="form-control" rows="3"></textarea>
								    </div>
								  </div>
								 	<br /><br /><br /><br /><br />
								   <button type="submit" class="btn btn-primary btn-xs btn-block">保存</button>
							   </form>
						     </div>
						   </div>
						 </div>
						 </td>
					 </tr>
				   </table>
			   </div>
			   
		  </div>
		</div>
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>
