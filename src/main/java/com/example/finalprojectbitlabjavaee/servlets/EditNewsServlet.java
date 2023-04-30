package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.News;
import com.example.finalprojectbitlabjavaee.NewsCategory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/editNews")
public class EditNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        News news = DBManager.getNews(id);
        ArrayList<NewsCategory> newsCategories = DBManager.getAllNewsCategories();
        request.setAttribute("news", news);
        request.setAttribute("newsCategories", newsCategories);
        request.getRequestDispatcher("/editNews.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Long category_id = Long.valueOf(request.getParameter("category_id"));
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        NewsCategory category = DBManager.getNewsCategory(category_id);
        news.setCategory(category);
        news.setId(id);
        DBManager.editNews(news);
        response.sendRedirect("/");
    }
}
