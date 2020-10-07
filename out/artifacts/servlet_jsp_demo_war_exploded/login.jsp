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
    <title>Title</title>
</head>
<body>
<div id="include-form">
    <h1 id="form-title"><font>学生信息管理系统</font></h1>
    <br />
    <form class="form-horizontal">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" placeholder="账号">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 记住我
                    </label>
                </div>
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
</body>
</html>
