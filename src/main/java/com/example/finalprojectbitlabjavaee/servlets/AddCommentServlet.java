package com.example.finalprojectbitlabjavaee.servlets;

import com.example.finalprojectbitlabjavaee.Comments;
import com.example.finalprojectbitlabjavaee.DBManager;
import com.example.finalprojectbitlabjavaee.News;
import com.example.finalprojectbitlabjavaee.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "/signIn";

        Users currentUser = (Users) request.getSession().getAttribute("currentUser");
        if(currentUser!=null) {
            String commentText = request.getParameter("comment");
            Long newsId = Long.parseLong(request.getParameter("news_id"));
            News news = DBManager.getNews(newsId);
            if(news!=null){
                Comments comment = new Comments();
                comment.setComment(commentText);
                comment.setUser(currentUser);
                comment.setNews(news);
                if(DBManager.addComment(comment)){
                    redirect = "/readNews?id="+newsId;
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
