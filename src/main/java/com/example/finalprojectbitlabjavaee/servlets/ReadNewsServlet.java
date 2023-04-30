package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.Comments;
import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.News;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/readNews")
public class ReadNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        News news = DBManager.getNews(id);
        if(news!=null){

            ArrayList<Comments> comments = DBManager.getAllComments(news.getId());
            request.setAttribute("news", news);
            request.setAttribute("comments", comments);

        }
        request.getRequestDispatcher("/newsdetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
