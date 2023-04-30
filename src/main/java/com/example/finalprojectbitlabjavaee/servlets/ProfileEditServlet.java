package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProfileEditServlet", value = "/ProfileEditServlet")
public class ProfileEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null){
            request.getRequestDispatcher("/profileEdit.jsp").forward(request,response);
        }else request.getRequestDispatcher("/signIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updFullName = request.getParameter("full_name");
        String updPassword = request.getParameter("password");

        String redirect = "/profileEditServlet?error";
        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
            Users user = DBManager.editUser(currentUser.getEmail(),currentUser.getEmail(),updFullName,updPassword);
            if(user != null){

                request.getSession().setAttribute("currentUser", user);
                redirect = "/profile?success";

            }



        response.sendRedirect(redirect);
    }
}
