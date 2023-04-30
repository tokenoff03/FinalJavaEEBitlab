package com.example.finalprojectbitlabjavaee;

import java.sql.Timestamp;

public class News {
    private Long id;

    private Timestamp postDate;

    private NewsCategory category;

    private String title;

    private String content;

    public News() {
    }

    public News(Long id, Timestamp postDate, NewsCategory category, String title, String content) {
        this.id = id;
        this.postDate = postDate;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public NewsCategory getCategory() {
        return category;
    }

    public void setCategory(NewsCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}