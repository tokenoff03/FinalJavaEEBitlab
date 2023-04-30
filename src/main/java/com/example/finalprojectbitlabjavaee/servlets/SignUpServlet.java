package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/signUp?emailerror";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        Users checkUser = DBManager.getUser(email);
        if(checkUser==null){ //Проверяем, если пользователя с таким email не существует
            redirect = "/signUp?passworderror";
            if(password.equals(rePassword)){

                Users user = new Users();
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(fullName);
                user.setRole_id("2");
                if(DBManager.addUser(user)){

                    redirect = "/signIn?success";

                }
            }
        }
        response.sendRedirect(redirect);
    }
}
