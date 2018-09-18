<%--
  Created by IntelliJ IDEA.
  User: yanghuan
  Date: 2018/9/12
  Time: 9:56
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="margin-top: 30px">
    <nav class="navbar navbar-default" role="navigation" style="background-color: white; border: none" >
        <div class="container-fluid" >
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <img src="<%=basePath%>/img/logo.png" style="width: 130px"  alt="">
            </div>
            <div class="collapse navbar-collapse" style="margin-left: 20px" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">首页</a></li>
                    <li><a href="#">开始订餐</a></li>
                    <li><a href="#">个人中心</a></li>
                    <li><a href="#">手机订餐APP</a></li>
                    <li><a href="<%=basePath%>/jsp/cart.jsp">购物车</a></li>
                </ul>
                <form action="##" class="navbar-form navbar-right" rol="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="输入商品名" />
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <div class="nav navbar-nav navbar-right">
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
        </div>
    </nav>

    <!-- 左侧菜单选项========================================= -->
    <div class="row" style="margin-top: 50px">
        <div class="col-sm-2 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <!-- 一级菜单 -->
                    <li ><a href="<%=basePath%>/List" class="nav-header menu-first collapsed" >
                        <div><i class="fa fa-user"></i>&nbsp; 全部 <span class="sr-only">(current)</span></div></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=1" class="nav-header menu-first collapsed" >
                        <div><i class="fa fa-user"></i>&nbsp; 美味汉堡 <span class="sr-only">(current)</span></div></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=2" class="nav-header menu-first collapsed" >
                        <i class="fa fa-globe"></i>&nbsp; 轻松卷类 <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=3" class="nav-header menu-first collapsed" >
                        <i class="fa fa-file-text"></i>&nbsp; 缤纷小食 <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=4" class="nav-header menu-first collapsed" >
                        <i class="fa fa-coffee"></i>&nbsp; 缤纷饮料 <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=5" class="nav-header menu-first collapsed" >
                        <i class="fa fa-file-text"></i>&nbsp; 吮指原味鸡 <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="<%=basePath%>/ListByKind?kid=6" class="nav-header menu-first collapsed" >
                        <i class="fa fa-file-text"></i>&nbsp; 营养早餐 <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
        </div>
        <!-- 右侧内容展示==================================================   -->
        <div class="col-sm-10  col-md-10  main">
            <c:forEach items="${goodsList}" var="good">
            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6"><!-- 大屏幕放3张略缩图，pc端放4张，平板和手机放6张-->
                <div class="thumbnail">
                    <img src="${good.img}" alt="..." style="width: 180px;height: 100px" class="img-responsive">
                    <div class="caption">
                        <span>${good.gname}</span>
                        <span>${good.price}元/份</span>
                    </div>
                    <a href="<%=basePath %>/addCart?id=${good.id}"><img src="<%= basePath%>/img/gwc.png" alt=""></a>
                </div>
            </div>
            </c:forEach>

            <!-- 第一张略缩图结束 -->
            <%--商品展示--%>
        </div>

    </div>

    <nav style="text-align: center">
        <ul class="pagination">
            <li><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li class="disabled"><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>
    </nav>
</div>



</body>
</html>
