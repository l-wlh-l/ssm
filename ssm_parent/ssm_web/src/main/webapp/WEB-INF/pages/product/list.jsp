<%--
  Created by IntelliJ IDEA.
  User: wlh
  Date: 2019/3/2
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><input name="ids" type="checkbox"></td>
            <td>${product.id}</td>
            <td>${product.productNum}</td>
            <td>${product.productName}</td>
            <td>${product.departureTime}</td>
            <td>${product.productStatus==1?"开启":"关闭"}</td>
            <td class="text-center">
                <button type="button" class="btn bg-olive btn-xs"
                        onclick='location.href="all-order-manage-edit.html"'>订单
                </button>
                <button type="button" class="btn bg-olive btn-xs"
                        onclick='location.href="all-order-manage-edit.html"'>查看
                </button>
            </td>
        </tr>
    </c:forEach>
</body>
</html>
