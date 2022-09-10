<%--
  Created by IntelliJ IDEA.
  User: Parisa
  Date: 9/9/2022
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">hi ${sessionScope.user.username}</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/person/findAll.do">PERSON</a></li>
            <li><a href="/car/findAll.do">CAR</a></li>
        </ul>
    </div>
</nav>