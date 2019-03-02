<%--
  Created by IntelliJ IDEA.
  User: wlh
  Date: 2019/3/1
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1px" align="center" width="66%" cellspacing="1px">
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>昵称</td>
        <td>家乡</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.nickname}</td>
            <td>${user.hometown}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
