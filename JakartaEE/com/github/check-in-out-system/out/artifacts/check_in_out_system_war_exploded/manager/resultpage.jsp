<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Parisa
  Date: 9/12/2022
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/menu.jsp"/>
<div class="container fit">
    <div class="panel panel-primary ">
        <div class="panel-heading center ">Hi dear Boss</div>
        <div class="panel-body">
            <table class="table table-striped table-hover fit">
                <tr>
                    <td>ID</td>
                    <td>USERNAME</td>
                    <td>LOGIN</td>
                    <td>LOGOUT</td>
                </tr>
                <c:forEach items="${requestScope.listTime}" var="time">
                    <tr>
                        <form action="/manager/findTime.do">
                            <td><input type="text" class="form-control fit" name="id" value="${time.id}" readonly/></td>
                            <td><input type="text" class="form-control fit" name="username" value="${time.username}" /></td>
                            <td><input type="text" class="form-control fit" name="login" value="${time.login}"/></td>
                            <td><input type="text" class="form-control fit" name="logout" value="${time.logout}"/></td>

                        </form>
                    </tr>
                </c:forEach>
            </table>


        </div>
</body>
</html>
