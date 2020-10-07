<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="../css/threebar.css"/>
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<link rel="stylesheet" type="text/css" href="../css/userManger.css"/>
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
				   <h4>首页/用户管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form>
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">用户名</span>
			    <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
			  </div>
			  
			 <div id="input2">
		     <span id="sp1">用户类型</span>
			<select class="form-control" id="sel1" > 
			  <option value="" disabled selected>选择用户类型</option>
			  <option>学生</option>
			  <option>管理员</option>
			  <option>教师</option>
			 
			</select>
			</div> 
			
			<input class="btn btn-default" type="submit" value="搜索">
			
			</form>
			   </div>
			   <br /><br />
			   <div class="right-group">
				 <a href="#" class="btn btn-primary btn-sm active" role="button">添加学生</a>
			     <a href="#" class="btn btn-primary btn-sm active" role="button">添加教师</a>
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
					 <tr>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td> <a href="#" class="btn btn-default btn-sm active" role="button">切换</a></td>
						 <td></td>
						 <td> <a href="#" class="btn btn-danger btn-sm active" role="button">删除</a></td>
					 </tr>
				   </table>
			   </div>
			   
		  </div>
		</div>
		
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="../js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="../js/bootstrap.min.js"></script>
	</body>
</html>
