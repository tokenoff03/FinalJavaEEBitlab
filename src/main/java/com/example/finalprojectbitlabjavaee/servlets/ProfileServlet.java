package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null){
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }else request.getRequestDispatcher("/signIn.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
