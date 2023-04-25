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
<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding:30px; text-align:center">
					<table width="60%" border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="${pageContext.request.contextPath}/client/images/RP.jpg" width="128" height="128" />
							</td>
							<td style="padding-top:30px">
								<font style="font-weight:bold; color:#FF0000">注册成功,别忘记激活帐户啊！</font><br />
								<br /> 
								<a href="${pageContext.request.contextPath }/index.jsp">
									 返回首页
								</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1></td>
			</tr>
		</table>
	</div>
	
<!--5. 网上书城底部 start -->
      <%@ include file="foot.jsp" %>
<!-- 网上书城底部  end -->
</body>
</html>