<%@ page import="com.example.finalprojectbitlabjavaee.News" %>
<%@ page import="com.example.finalprojectbitlabjavaee.NewsCategory" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 11:16 PM
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
  <form method="post" action="/editNews" style="width: 60%; margin-left: auto; margin-right: auto; margin-top: 100px">
    <%
      News news = (News) request.getAttribute("news");
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
      <label for="exampleInputEmail1" class="form-label">Title</label>
      <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" value="<%=news.getTitle()%>">
      <input type="hidden" class="form-control" id="examsad" aria-describedby="emailHelp" name="id" value="<%=news.getId()%>">
    </div>
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Content</label>
      <textarea class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp" name="content"><%=news.getContent()%></textarea>
    </div>
    <div class="mb-3">
      <select name="category_id" id="category">
        <%
          ArrayList<NewsCategory> newsCategories = (ArrayList<NewsCategory>) request.getAttribute("newsCategories");
          if(newsCategories!=null){
            for(NewsCategory nc: newsCategories){

        %>
        <option value="<%=nc.getId()%>">
          <%=nc.getName()%>
        </option>
        <%
            }
          }
        %>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  <%@include file="vendor/footer.jsp"%>
</body>
</html>
