<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.finalprojectbitlabjavaee.NewsCategory" %><%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 8:46 PM
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
    <div class="container" style="min-height: 500px;">
      <div class="row mt-3">
        <div class="col-8 mx-auto">
          <%
            String success = request.getParameter("success");
            if(success!=null){
          %>
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            News added successfully!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
          <%
            }
          %>

          <%
            String error = request.getParameter("error");
            if(error!=null){
          %>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            Error on adding news!
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
          <%
            }
          %>

          <form action="/newsAdd" method="post">
            <div class="row">
              <div class="col-12">
                <label>TITLE </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <input type="text" class="form-control" name="title" placeholder="Title">
              </div>
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <label>CONTENT </label>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
                <textarea class="form-control" name="content" rows="5" placeholder="Content"></textarea>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-12">
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
            </div>
            <div class="row mt-3">
              <div class="col-12">
                <button class="btn btn-success">ADD News</button>
              </div>
            </div>
          </form>
        </div>
      </div>

    </div>

    <%@include file="vendor/footer.jsp"%>
</body>
</html>
