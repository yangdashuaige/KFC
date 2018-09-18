<%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/10
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <meta charset="utf-8" />
  <title>bootstrap案例</title>
  <!--用百度的静态资源库的cdn安装bootstrap环境-->
  <!-- Bootstrap 核心 CSS 文件 -->
  <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
  <!--font-awesome 核心我CSS 文件-->
  <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- 在bootstrap.min.js 之前引入 -->
  <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
  <!-- Bootstrap 核心 JavaScript 文件 -->
  <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <!--jquery.validate-->
  <script type="text/javascript" src="<%= basePath%>/js/jquery.validate.min.js" ></script>
  <script type="text/javascript" src="<%= basePath%>/js/message.js" ></script>
  <style type="text/css">
    body{background: url(img/kfc.jpg) no-repeat;background-size: cover;font-size: 16px;}
    .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
    #login_form{display: block;}
    #register_form{display: none;}
    .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
    input[type="text"],input[type="password"]{padding-left:26px;}
    .checkbox{padding-left:21px;}
  </style>
</head>
<body>
<div class="container">
  <div class="form row">
    <form action="${path}/login" method="post" class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">
      <h3 class="form-title">登录账号</h3>
      <div class="col-sm-9 col-md-9">
        <div class="form-group">
          <i class="fa fa-user fa-lg"></i>
          <input class="form-control required" type="text" placeholder="用户名" name="username" autofocus="autofocus" maxlength="20"/>
        </div>
        <div class="form-group">
          <i class="fa fa-lock fa-lg"></i>
          <input class="form-control required" type="password" placeholder="密码" name="pwd" maxlength="8"/>
        </div>
        <div class="form-group">
          <label class="checkbox">
            <input type="checkbox" name="remember" value="1"/> 记住账号
          </label>
          <hr />
          <a href="javascript:;" id="register_btn" class="">新账户注册</a>
        </div>
        <div class="form-group">
          <span style="color: red" >
          <c:if test="${error == 1}">
         用户或密码不正确
          </c:if>
          </span>
        </div>
        <div class="form-group">
          <input id="reg_button" type="submit" class="btn btn-success pull-right" value="登录 "/>
        </div>
      </div>
    </form>
  </div>

  <div class="form row">
    <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">
      <h3 class="form-title">账号注册</h3>
      <div class="col-sm-9 col-md-9">
        <div class="form-group">
          <i class="fa fa-user fa-lg"></i>
          <input class="form-control required" type="text" placeholder="用户名" name="username" autofocus="autofocus"/>
        </div>
        <div class="form-group">
          <i class="fa fa-lock fa-lg"></i>
          <input class="form-control required" type="password" placeholder="密码" id="register_password" name="password"/>
        </div>
        <div class="form-group">
          <i class="fa fa-check fa-lg"></i>
          <input class="form-control required" type="password" placeholder="再次输入密码" name="rpassword"/>
        </div>
        <div class="form-group">
          <i class="fa fa-envelope fa-lg"></i>
          <input class="form-control eamil" type="text" placeholder="邮箱" name="email"/>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success pull-right" value="注册 "/>
          <input type="submit" class="btn btn-info pull-left" id="back_btn" value="返回"/>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src="<%= basePath%>js/main.js" ></script>
</body>
</html>
