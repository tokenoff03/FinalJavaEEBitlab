package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.News;
import com.example.finalprojectbitlabjavaee.NewsCategory;
import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/newsAdd")
public class NewsAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {
            ArrayList<NewsCategory> newsCategories = DBManager.getAllNewsCategories();
            request.setAttribute("newsCategories", newsCategories);
            request.getRequestDispatcher("/addNews.jsp").forward(request, response);
        }else{
            response.sendRedirect("/signIn");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/signIn";

        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {
            redirect = "/newsAdd?error";
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Long category_id = Long.valueOf(request.getParameter("category_id"));
            News news = new News();
            news.setTitle(title);
            news.setContent(content);

            news.setCategory(DBManager.getNewsCategory(category_id));
            if(DBManager.addNews(news)){
                redirect = "/newsAdd?success";
            }
        }
        response.sendRedirect(redirect);
    }
}
