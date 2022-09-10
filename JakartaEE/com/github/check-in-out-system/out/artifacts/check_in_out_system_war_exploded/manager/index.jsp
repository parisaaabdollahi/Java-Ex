<%--
  Created by IntelliJ IDEA.
  User: Parisa
  Date: 9/8/2022
  Time: 5:14 PM
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
<form action="save.do"  class="form-group">
    <input placeholder="enter name" type="text" name="name" class="form-control"/>
    <br/>
    <input placeholder="enter family" type="text" name="family" class="form-control"/>
    <br/>
    <input placeholder="enter username" type="text" name="family" class="form-control"/>
    <br/>
    <input placeholder="enter password" type="text" name="family" class="form-control"/>
    <br/>
    <input placeholder="enter role" type="text" name="family" class="form-control"/>
    <br/>
    <input type="submit" value="SAVE" class="btn btn-primary fit"/>
</form>
            <table class="table table-striped table-hover fit">
                <tr>

                    <td>NAME</td>
                    <td>FAMILY</td>
                    <td>USERNAME</td>
                    <td>PASSWORD</td>
                    <td>ROLE</td>
                    <td class="center">ACTION</td>
                    <td class="center">ACTION</td>
                </tr>
                <c:forEach items="${requestScope.list}" var="user">
                    <tr>
                        <form action="/update.do">
                            <td><input type="text" class="form-control fit" name="id" value="${user.name}" /></td>
                            <td><input type="text" class="form-control fit" name="name" value="${user.family}"/></td>
                            <td><input type="text" class="form-control fit" name="family" value="${user.username}"/></td>
                            <td><input type="text" class="form-control fit" name="family" value="${user.password}"/></td>
                            <td><input type="text" class="form-control fit" name="family" value="${user.role}"/></td>
                            <td><input type="submit" value="UPDATE" class="btn btn-warning fit"></td>
                            <td><input type="button" onclick="removeuser(${user.username})" value="REMOVE"
                                       class="btn btn-danger fit"></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <script>
        function removeUser(username) {
            if (confirm('are you sure?'))
                window.location = '/remove.do?id=' + username;
        }
    </script>
</div>
</body>

</html>
