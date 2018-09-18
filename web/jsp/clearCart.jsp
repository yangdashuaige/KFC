<%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/11
  Time: 21:16
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
    <title>Title</title>
</head>
<body>
<a href="<%=basePath%>/List">继续购物</a>
<a href="<%=basePath %>/loginOut">退出</a>
</body>
</html>
