<%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>

    <form action="/signIn" method="post" style="width: 60%; margin-left: auto; margin-right: auto; margin-top: 250px">
        <%
            String error = request.getParameter("emailError");
            if(error!=null){

        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Incorrect <strong>email</strong> or <strong>password</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>

        <%
            String success = request.getParameter("success");
            if(success!=null){

        %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User was  <strong>created</strong> successfully.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <%
            }
        %>
        <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
          <input type="text" class="form-control-plaintext" id="staticEmail" name="email" placeholder="Email">
        </div>
      </div>
      <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
          <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
        </div>
      </div>
      <button class="btn btn-success" style="margin-top: 10px">Sign In</button>
        <a class="btn btn-success" style="margin-top: 10px" href="/signUp">Sign Up</a>
    </form>
</body>
</html>
