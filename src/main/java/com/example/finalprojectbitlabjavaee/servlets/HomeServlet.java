package com.example.finalprojectbitlabjavaee.servlets;

import java.io.*;
import java.util.ArrayList;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<News> news = DBManager.getAllNews();
        request.setAttribute("news", news);
        request.getRequestDispatcher("/news.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
}