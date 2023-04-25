<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    $(function () {
      // console.log("login");
      $("button.AddCartBtn").click(function () {
        // console.log("click");
        let num = parseInt($("input.num").val());
        let pid = parseInt($(this).attr("pid"));
        // console.log(num + "  " + pid);
        $.ajax({
          url:'/addOrderItem',
          type:'post',
          dataType:'text',
          data:'type=add&pid=' + pid + '&num=' + num,
          success:function (data) {
          		alert("添加购物车成功")
          }
        });
      })
    });
  </script>
</head>
<body>
<c:if test="${!empty user}">
  <div align="center">
    当前用户: ${user.name}
  </div>
</c:if>
<table align='center' border='1' cellspacing='0'>
  <tr>
    <td>id</td>
    <td>名称</td>
    <td>价格</td>
    <td>购买</td>
  </tr>
  <c:forEach items="${list}" var="product" varStatus="st">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>数量<input class="num" type="text" value="1" name="num">
<%--          <input id="addCart" type="submit" value="购买">--%>
        <!--多个部件不用id选择器，用类选择器-->
          <button class="AddCartBtn" pid="${product.id}">加入购物车</button>
      </td>

    </tr>
  </c:forEach>
</table>
<a href="listOrderItem.jsp">购物车</a>
<%--<form action="/productList" method="get">
  <input type="submit" value="购物车"/>--%>
</body>
</html>
