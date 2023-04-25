<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
<!-- 导入首页轮播图css和js脚本 -->
<link type="text/css" href="${pageContext.request.contextPath}/client/css/autoplay.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/autoplay.js"></script>
</head>
<body class="main">
<!-- 1.网上书城顶部 start -->
	  <%@include file="head.jsp"%>
<!-- 网上书城顶部  end -->

<!-- 2.网上书城菜单列表  start -->
	<%@include file="menu_search.jsp" %>
<!-- 网上书城菜单列表  end -->
    <div class="list">
    <div><img src="${pageContext.request.contextPath}/client/images/TV1.png" style="margin-top:45px;" width="900" height="555"></div>
    <div><center><h3 style="font-size:25px;">海尔44寸液晶电视</h3><a href="#" style="font-size:25px;">点击购买</a></center></div>
    <div><img src="${pageContext.request.contextPath}/client/images/TV2.png" style="margin-top:45px;" width="900" height="555"></div>
    <div><center><h3 style="font-size:25px;">乐华28英寸液晶电视</h3><a href="#" style="font-size:25px;">点击购买</a></center></div>
    <div><img src="${pageContext.request.contextPath}/client/images/TV3.png" style="margin-top:45px;" width="900" height="555"></div>
    <div><center><h3 style="font-size:25px;">索尼X8500E液晶电视</h3><a href="#" style="font-size:25px;">点击购买</a></center></div>
    </div>
    </body>
<%@ include file="foot.jsp" %>
</html>