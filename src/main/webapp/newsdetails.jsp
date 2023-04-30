<%@ page import="com.example.finalprojectbitlabjavaee.News" %>
<%@ page import="com.example.finalprojectbitlabjavaee.Comments" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Адиль
  Date: 4/30/2023
  Time: 10:07 PM
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
        <div class="col-12">
          <%
            News news = (News) request.getAttribute("news");
            if(news!=null){
          %>
          <div class="row mt-3">
            <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">
              <h2><%=news.getTitle()%></h2>
              <p class="mt-2"><%=news.getContent()%></p>
              <p class="mt-2">
                Posted at <strong><%=news.getPostDate()%></strong> with category <strong><%=news.getCategory().getName()%></strong>
              </p>
                <%

                    if(curretUser!=null){

                %>

                <div class="row mt-2">
                    <div class="col-12">
                        <form action="/addcomment" method="post">
                            <input type="hidden" name="news_id" value="<%=news.getId()%>">
                            <textarea class="form-control" name="comment" placeholder="Write a comment"></textarea>
                            <button class="btn btn-success mt-3">ADD COMMENT</button>
                        </form>
                    </div>
                </div>
                <%
                    }
                %>
                <hr>

                <%

                    ArrayList<Comments> comments = (ArrayList<Comments>) request.getAttribute("comments");

                    if(comments!=null){

                        for(Comments comment : comments){

                %>

                <div class="row mt-2">

                    <div class="col-12">
                        <%
                            if(curretUser!=null && curretUser.getRole_id().equals("1")){
                        %>
                        <a href="/deleteComment?id=<%=comment.getId()%>&news_id=<%=news.getId()%>" type="button" class="btn btn-danger" style="float: right;">Delete</a>
                        <%
                            }
                        %>
                        <h5><%=comment.getUser().getFullName()%></h5>

                        <p><%=comment.getComment()%></p>

                        <p>At <strong><%=comment.getPost_date()%></strong></p>

                    </div>

                </div>

                <%

                        }

                    }

                %>
            </div>
          </div>
          <%
            }
          %>

        </div>

      </div>

    </div>

    <%@include file="vendor/footer.jsp"%>
</body>
</html>
