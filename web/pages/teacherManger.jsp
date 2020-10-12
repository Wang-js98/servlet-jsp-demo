${pageContext.request.contextPath}
<html>
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
				   <h4>首页/教师管理</h4>
			   </div>
			   <br />
			  <div id="rig2" class="right-group">
				   <h2>搜索信息</h2>
			  <form>
			  <div class="input-group" id="input1">
			    <span class="input-group-addon" id="basic-addon1">教师姓名</span>
			    <input type="text" class="form-control" placeholder="教师姓名" aria-describedby="basic-addon1">
			  </div>
			  
			 <div id="input2">
		     <span id="sp1">教师学历</span>
			<select class="form-control" id="sel1" > 
			  <option value="" disabled selected>选择学历</option>
			  <option>博士</option>
			  <option>研究生</option>
			  <option>本科</option>
			  <option>高中</option>
			 
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
					 <tr>
						 <td></td>
						 <td></td>
						 <td></td>
						 <td> </td>
						 <td></td>
						 <td> 
						 
						 <!-- Large modal -->
						 <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">工作安排</button>
						 
						 <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
						   <div class="modal-dialog modal-lg" role="document">
						     <div class="modal-content">
								 <h2>工作安排</h2>
						       <form>
								   选择课程
								   <label class="radio-inline">
								     <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 英语
								   </label>
								   <label class="radio-inline">
								     <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 语文
								   </label>
								   <label class="radio-inline">
								     <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 数学
								   </label>
								   <br /><br />
								   
								   选择班级
								   <label class="checkbox-inline">
								     <input type="checkbox" id="inlineCheckbox1" value="option1"> 二年一班
								   </label>
								   <label class="checkbox-inline">
								     <input type="checkbox" id="inlineCheckbox2" value="option2"> 二年二班
								   </label>
								   <label class="checkbox-inline">
								     <input type="checkbox" id="inlineCheckbox3" value="option3"> 二年三班
								   </label>
								   <br /><br />
								   <input class="btn btn-primary btn-sm " type="submit" value="保存">&nbsp;
								    <input class="btn btn-primary btn-sm " type="reset" value="重置">
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
