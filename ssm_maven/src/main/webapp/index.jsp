<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<html>
<title>首页</title>
<style>
    div {
        margin-bottom: 10px;
        padding: 5px;
    }
</style>
<body>
<div>
    <fieldset>
        <legend>测试-----01------requestMapping添加类和方法上</legend>
        <a href="${ctx}/user/findAll">点我测试</a>
    </fieldset>


</div>

</body>