<%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
    <form action="/signUp" method="post" style="width: 60%; margin-left: auto; margin-right: auto; margin-top: 250px">
        <%
            String emailError = request.getParameter("emailerror");
            if(emailError!=null){
        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Email is busy!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <%
            }
        %>

        <%
            String passwordError = request.getParameter("passworderror");
            if(passwordError!=null){
        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Passwords are not same!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <%
            }
        %>


        <div class="form-group row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control-plaintext" id="staticEmail" name="email" placeholder="Email">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
        </div>
        <div class="form-group row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Full Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control-plaintext" id="nameFull" name="full_name" placeholder="Email">

            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Repeat Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword2" name="re_password" placeholder="Repeat Password">
            </div>
        </div>
        <button class="btn btn-success" style="margin-top: 10px">Sign Up</button>
    </form>
</body>
</html>
