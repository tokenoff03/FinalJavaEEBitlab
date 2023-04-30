<%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 6:16 PM
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

    <form method="post" action="/ProfileEditServlet" style="width: 60%; margin-left: auto; margin-right: auto; margin-top: 100px">
        <%
            String error = request.getParameter("error");
            if(error!=null){

        %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Something went <strong>wrong!</strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
            }
        %>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Full Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="full_name" value="<%=curretUser.getFullName()%>">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input type="text" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" name="email" value="<%=curretUser.getEmail()%>">
        </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="password" value="<%=curretUser.getPassword()%>">
            </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <%@include file="vendor/footer.jsp"%>
</body>
</html>
