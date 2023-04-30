package com.example.finalprojectbitlabjavaee;

import java.sql.Timestamp;

public class Comments {
    private Long id;
    private String comment;

    private Timestamp post_date;

    private Users user;

    private News news;

    public Comments() {
    }

    public Comments(Long id, String comment, Timestamp post_date, Users user, News news) {
        this.id = id;
        this.comment = comment;
        this.post_date = post_date;
        this.user = user;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
