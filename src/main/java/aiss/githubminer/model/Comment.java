package aiss.githubminer.model;

import aiss.githubminer.model.commentParser.CommentParser;

public class Comment {
    public String id;
    public String body;
    public String created_at;
    public String updated_at;
    public User author;

    public Comment(String id, String body, String created_at, String updated_at, User author) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //Todo terminar constructor 1. hay que parsear el body para obtener solo lo que se quiere
    // 2. hay que obtener el nombre del autor del body
    public static Comment of(CommentParser commentData) {
        String id = commentData.getId().toString();
        String body = commentData.getBody();
        String created_at = commentData.getCreatedAt();
        String updated_at = commentData.getUpdatedAt();
        User author = commentData.getUserModel();
        return new Comment(
                id,
                body,
                created_at,
                updated_at,
                author
        );
    }
}
