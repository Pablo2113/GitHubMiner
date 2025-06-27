package aiss.githubminer.model;

import aiss.githubminer.model.commentParser.CommentParser;

public class Comment {
    public String id;
    public String body;
    public String created_at;
    public String updated_at;
    public User author;


    public Comment(String id, String body, String created_at, String updated_at, User author ) {
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

    public static Comment of(CommentParser comment) {
        String id = comment.getId().toString();
        String body = comment.getBody();
        String created_at = comment.getCreatedAt();
        String updated_at = comment.getUpdatedAt();
        User author = comment.getUserModel();
        return new Comment(
                id,
                body,
                created_at,
                updated_at,
                author
        );
//hygwy

    }
}
