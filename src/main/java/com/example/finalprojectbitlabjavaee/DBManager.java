package com.example.finalprojectbitlabjavaee;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FinalBitlabEE",
                    "postgres","00000000");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Users getUser(String email){
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM public.users WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("role_id")
                );
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static Users editUser(String currentEmail,String updEmail, String updFullName, String updPassword){
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "UPDATE public.users SET full_name = ?, email=?,password=? WHERE email = ?;");
            statement.setString(1,updFullName);
            statement.setString(2,updEmail);
            statement.setString(3,updPassword);
            statement.setString(4,currentEmail);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        user = getUser(updEmail);
        return user;
    }

    public static boolean addUser(Users user){
        int rows =0;
        try {
            PreparedStatement statement = connection.prepareStatement("" +   "INSERT INTO users (email, password, full_name,role_id) " +
                    "VALUES (?, ?, ?,?)");
            statement.setString(1,user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3,user.getFullName());
            statement.setString(4,user.getRole_id());
            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows >0;
    }

    public static boolean addNews(News news){

        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (category_id, title, content, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, news.getCategory().getId());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;

    }

    public static ArrayList<News> getAllNews(){
        ArrayList<News> news = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.post_date, n.category_id, nc.id AS nc_id, nc.name " +
                    "FROM news n " +
                    "INNER JOIN news_categories nc ON nc.id = n.category_id " +
                    "ORDER BY n.post_date DESC ");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                News news1 = new News();
                news1.setId(resultSet.getLong("id"));
                news1.setTitle(resultSet.getString("title"));
                news1.setContent(resultSet.getString("content"));
                news1.setPostDate(resultSet.getTimestamp("post_date"));
                NewsCategory newsCategory = new NewsCategory();
                newsCategory.setId(resultSet.getLong("category_id"));
                newsCategory.setName(resultSet.getString("name"));

                news1.setCategory(newsCategory);
                news.add(news1);

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static NewsCategory getNewsCategory(Long id){
        NewsCategory category = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM public.news_categories WHERE id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                category = new NewsCategory(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    public static ArrayList<NewsCategory> getAllNewsCategories(){
        ArrayList<NewsCategory> newsCategories = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM public.news_categories");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                NewsCategory newsCategory = new NewsCategory(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );

                newsCategories.add(newsCategory);

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsCategories;
    }

    public static News getNews(Long id){
        News news1 = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.post_date, n.category_id, nc.id AS nc_id, nc.name " +
                    "FROM news n " +
                    "INNER JOIN news_categories nc ON nc.id = n.category_id " +
                    "WHERE n.id = ?");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                news1 = new News();
                news1.setId(resultSet.getLong("id"));
                news1.setTitle(resultSet.getString("title"));
                news1.setContent(resultSet.getString("content"));
                news1.setPostDate(resultSet.getTimestamp("post_date"));
                NewsCategory newsCategory = new NewsCategory();
                newsCategory.setId(resultSet.getLong("category_id"));
                newsCategory.setName(resultSet.getString("name"));

                news1.setCategory(newsCategory);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news1;
    }

    public static boolean addComment(Comments comment){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (user_id, news_id, comment, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, comment.getUser().getId());
            statement.setLong(2, comment.getNews().getId());
            statement.setString(3, comment.getComment());
            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Comments> getAllComments(Long newsId){
        ArrayList<Comments> comments = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.user_id, c.comment, c.news_id, u.full_name, u.email, c.post_date " +
                    "FROM comments c " +
                    "INNER JOIN users u ON c.user_id = u.id " +
                    "WHERE c.news_id = ? " +
                    "ORDER BY c.post_date DESC");

            statement.setLong(1, newsId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Comments comment = new Comments();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPost_date(resultSet.getTimestamp("post_date"));
                Users user = new Users();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                comment.setUser(user);
                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                comment.setNews(news);
                comments.add(comment);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static void deleteCommentByNewsId(Long news_id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from public.comments where news_id=?");

            statement.setLong(1, news_id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteCommentById(Long id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from public.comments where id=?");

            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteNewsById(Long news_id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from public.news where id=?");
            statement.setLong(1, news_id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void editNews(News news){

        try {
            PreparedStatement statement = connection.prepareStatement("" + "UPDATE public.news SET title = ?, content=?,category_id=? WHERE id = ?;");
            statement.setString(1,news.getTitle());
            statement.setString(2,news.getContent());
            statement.setLong(3,news.getCategory().getId());
            statement.setLong(4,news.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


