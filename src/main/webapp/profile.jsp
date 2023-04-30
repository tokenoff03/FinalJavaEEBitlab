<%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/25/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendor/head.jsp"%>

</head>
<body>
    <%@include file="vendor/header.jsp"%>

    <div style="text-align: center; width: 60%; margin-right: auto; margin-left: auto">
        <%
            String check = request.getParameter("success");
            if(check!=null){

        %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            User was <strong>edited</strong> successfully
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>
        <p>FULL NAME: <%=curretUser.getFullName()%></p>
        <p>Email: <%=curretUser.getEmail()%></p>
        <%
            if(curretUser.getRole_id().equals("1")){
        %>
            <p>Role: Administrator</p>
        <%
            }else{
        %>
            <p>Role: User</p>
        <%
            }
        %>

        <a type="button" class="btn btn-primary" href="/ProfileEditServlet">Edit</a>
    </div>
    <%@include file="vendor/footer.jsp"%>
</body>
</html>
