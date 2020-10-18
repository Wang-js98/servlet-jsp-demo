<%--
  Created by IntelliJ IDEA.
  User: 37423
  Date: 2020-10-07
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" media="all" href="css/login.css" />
    <title>学生信息管理系统</title>
</head>
<body>
<div id="include-form">
    <h1 id="form-title"><font>学生信息管理系统</font></h1>
    <br />
    <form class="form-horizontal" action="login" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text"  name="userName" class="form-control" id="inputEmail3" placeholder="账号">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">验证码</label>
            <div class="col-sm-10">
                <input id="checks" name="checks" class="form-control" type="text"  style="width:90px;float: left" />

                <img id="imgVerify" style="width:95px;float: left;margin-left: 20px;height: 34px" src="userServlet?action=getVerify" alt="点击更换验证码" onclick="this.src=this.src+'&'"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                ${requestScope.loginmsg}
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">登录</button>
                &nbsp;&nbsp;&nbsp;
                <button type="reset" class="btn btn-default">重置</button>
            </div>
        </div>
    </form>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
