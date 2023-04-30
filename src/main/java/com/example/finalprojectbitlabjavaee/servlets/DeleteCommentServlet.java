package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Long news_id = Long.parseLong(request.getParameter("news_id"));
        DBManager.deleteCommentById(id);
        response.sendRedirect("/readNews?id="+news_id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
