<%--
  Created by IntelliJ IDEA.
  User: Parisa
  Date: 9/8/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <jsp:include page="/WEB-INF/head.jsp"/>
  </head>
  <body>

  <div class="container fit">
    <div class="panel panel-primary ">
      <div class="panel-heading center ">LOGIN PLEASE</div>
      <div class="panel-body">

  <form action="/login.do" class="form-group ">
    <input placeholder="enter your Employee Code" type="text" name="username" class="form-control "/>
    <br/>
    <input placeholder="enter your Password" type="password" name="password" class="form-control "/>
    <br/>
    <input type="submit" value="LOGIN" class="btn btn-primary  fit "/>
  </form>
      </div>
    </div>
  </div>

  </body>
</html>
