package com.example.mhmdreza_j.mobile_p2;

public class Comment {
    private int userId;
    private int postId;
    private String name;
    private String email;
    private String body;

    public Comment(int userId, int postId, String name, String email, String body) {
        this.userId = userId;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
