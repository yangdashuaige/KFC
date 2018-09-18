<%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/10
  Time: 21:15
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
    <title>list页面</title>
    <style>
        div.menu ul
        {
            list-style:none; /* 去掉ul前面的符号 */
            margin: 0px; /* 与外界元素的距离为0 */
            padding: 0px; /* 与内部元素的距离为0 */
            width: auto; /* 宽度根据元素内容调整 */
        }
        div.menu ul li
        {
            float:left; /* 向左漂移，将竖排变为横排 */
        }

        div .menurig{
            float: right;
        }
        div.menu ul li a, div.menu ul li a:visited {
            background-color: #465c71; /* 背景色 */
            border: 1px #4e667d solid; /* 边框 */
            color: #dde4ec; /* 文字颜色 */
            display: block; /* 此元素将显示为块级元素，此元素前后会带有换行符 */
            line-height: 1.35em; /* 行高 */
            padding: 4px 20px; /* 内部填充的距离 */
            text-decoration: none; /* 不显示超链接下划线 */
            white-space: nowrap; /* 对于文本内的空白处，不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。 */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="menu">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="">开始订餐</a></li>
            <li><a href="">个人中心</a></li>
            <li><a href="">手机订餐APP</a></li>
            <li><a href="<%=basePath%>/jsp/cart.jsp">我的购物车</a></li>
            <li><a href="">帮助中心</a></li>
        </ul>
        <div class="menurig">
            <c:choose>
                <c:when test="${not empty uname}">
                    欢迎您,${uname},<a href="<%= basePath %>/loginOut">注销</a>
                </c:when>
                <c:otherwise>
                    <a href="<%= basePath %>/index.jsp">登录</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="body">
        <div class="left">
        </div>
        <div class="right">
            <table width="60%" style="border: 1px solid black;text-align: center" >
                <tr>
                    <th>图片</th>
                    <th>商品名</th>
                    <th>操作</th>
                </tr>
                <%--显示数据 el取域对象 核心标签库 导入--%>
                <%--循环 foreache  items 访问哪个集合(el表达式域对象取出)  var 取出一个对象取的名字--%>
                <c:forEach items="${goodsList}" var="good">
                <tr>
                    <td><img src="${good.img}" width="50px" height="50px"  alt=""></td>
                    <td>${good.gname}</td>
                    <td><a href="<%=basePath %>/addCart?id=${good.id}">加入购物车</a></td>
                </tr>
                </c:forEach>
        </div>
    </div>

</div>


</body>

</html>
