<%@ page import="com.example.finalprojectbitlabjavaee.Users" %><%
  Users curretUser = (Users) request.getSession().getAttribute("currentUser");
  boolean Online = false;

  if(curretUser!=null){
    Online = true;
  }
%>
