<%@ page import="com.example.finalprojectbitlabjavaee.News" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 8:05 PM
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
    <div class="container" style="min-height: 500px; margin-bottom: 150px;">
        <%

            if(curretUser!=null && curretUser.getRole_id().equals("1")){

        %>
            <a class="btn btn-success" style="margin-top: 10px;" href="/newsAdd">Add News</a>
        <%
            }
        %>
        <div class="row mt-3">
            <div class="col-12">
                <%
                    ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
                    if(news!=null){
                        for(News n : news){
                %>

                <div class="row mt-3">

                    <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">
                        <a href="/readNews?id=<%=n.getId()%>" type="button" class="btn btn-primary" style="float: right">Details</a>
                        <%
                            if(curretUser!=null && curretUser.getRole_id().equals("1")){
                        %>
                            <a href="/deleteNews?id=<%=n.getId()%>" type="button" class="btn btn-danger" style="float: right">Delete</a>
                            <a href="/editNews?id=<%=n.getId()%>" type="button" class="btn btn-danger" style="float: right">Edit</a>
                        <%
                            }
                        %>
                        <h2><%=n.getTitle()%></h2>
                        <p class="mt-2"><%=n.getContent()%></p>
                        <p class="mt-2">
                            Posted at <strong><%=n.getPostDate()%></strong> with category <strong><%=n.getCategory().getName()%></strong>
                        </p>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>

    <%@include file="vendor/footer.jsp"%>
</body>
</html>
