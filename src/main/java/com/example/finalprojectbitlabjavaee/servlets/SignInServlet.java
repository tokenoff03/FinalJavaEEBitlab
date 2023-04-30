package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/signIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String redirect = "/signIn?emailError";
        Users user = DBManager.getUser(email);

        if(user != null){
            if(user.getPassword().equals(password)){
                request.getSession().setAttribute("currentUser", user);
                redirect = "/profile";
            }
        }

        response.sendRedirect(redirect);
    }
}
