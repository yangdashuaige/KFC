<%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/10
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>


<head>
    <title>登录页面</title>
</head>
<body>
<form action="${path}/login" method="post">

<p>用户名：<input type="text" name="username"></p>
<p>密码<input type="password" name="pwd"></p>
    <p> <input type="submit" value="登录"/>
        <input type="reset" value="取消"/>
    </p>
</form>
<span style="color: red" >
       <c:if test="${error == 1}">
           用户或密码不正确
       </c:if>
</span>
</body>
</html>
