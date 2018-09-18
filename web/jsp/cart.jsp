<%@ page import="java.util.Map" %>
<%@ page import="com.KFC.pojo.Goods" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/10
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
    <title>购物车页面</title>
</head>
<body>
<c:choose >
    <c:when test="${not empty uname}">
        <%
            Map<Goods,Integer> map=(Map)session.getAttribute("cart");
            Set<Goods> key=map.keySet();
            double sums=0;
            if(key!=null)
            {
                for(Goods g:key) {
                    sums = sums + g.getPrice() * map.get(g);
                }
            }

            session.setAttribute("sums",sums);
        %>
        <table style="border: 1px solid black;align-items: center;text-align: center;  " width="80%" cellspacing="0">
            <tr>
                <th>操作</th>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品数量</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${cart}" var="cartItem">
                <tr>
                    <td><a href="<%=basePath %>/addCount?id=${cartItem.key.id}">增加</a></td>
                    <td><img src="<%=basePath %>/${cartItem.key.img}" width="50px" height="50px"  alt=""></td>

                    <td>${cartItem.key.gname}</td>
                    <td>${cartItem.key.price}</td>
                        <%--http://localhost:8080/web项目名/images/1.jps
                        jsp application  相当于servlet的 context
                        --%>
                    <td>${cartItem.value}</td>
                    <td class="add">${cartItem.value*cartItem.key.price}</td>
                    <td><a href="<%=basePath %>/delCart?id=${cartItem.key.id}">减少</a></td>
                </tr>
            </c:forEach>
        </table>

        合计：<span><%=sums %>元</span>
        <p><a href="<%= basePath%>/clearCart" onClick="return confirm('购买成功！')">结算</a></p>
    </c:when>
    <%--跳转到首页--%>
    <c:otherwise>
        <jsp:forward page="/login"></jsp:forward>
    </c:otherwise>
</c:choose>

</body>
</html>
