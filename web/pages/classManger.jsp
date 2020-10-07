<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="../css/threebar.css"/>
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<link rel="stylesheet" type="text/css" href="../css/classManger.css"/>
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
				   <h4>首页/班级管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form>
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">班级名称</span>
			    <input type="text" class="form-control" placeholder="班级名称" aria-describedby="basic-addon1">
			  </div>
			  
			
			<input class="btn btn-default" type="submit" value="搜索">
			
			</form>
			   </div>
			   <br /><br />
			 
			  
			   <div class="right-group">
				   
				   <table class="table table-hover">
				     <tr>
						 <th>编号</th>
						 <th>班级名称</th>
						 <th>创建时间</th>
						 <th>操作</th>
					 </tr>
					 <tr>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td> 
						 <a href="#" class="btn btn-danger btn-sm active" role="button">删除</a>
						 <!-- Large modal -->
						 <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">编辑</button>
						 
						 <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
						   <div class="modal-dialog modal-lg" role="document">
						     <div class="modal-content">
								 <h2>班级管理</h2>
						       <form>
								   <div class="form-group">
								      <label for="inputEmail3" class="col-sm-2 control-label">班级名称</label>
								      <div class="col-sm-10">
								        <input type="text" class="form-control" id="inputEmail3" >
								      </div>
								    </div>
									<br /><br /><br />
								   
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
		<script src="../js/jquery-3.2.1.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="../js/bootstrap.min.js"></script>
	</body>
</html>
