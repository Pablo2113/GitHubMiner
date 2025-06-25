package aiss.githubminer.model;

import aiss.githubminer.model.issueParser.IssueParser;

import java.util.List;

public class Issue {
    public String id;
    public String title;
    public String description;
    public String state;
    public String created_at;
    public String updated_at;
    public String closed_at;
    public List<String> labels;
    public Integer votes;
    public List<Comment> comments;
    public User author;
    public User assignee;

    public Issue(String id, String title, String description, String state, String created_at, String updated_at, String closed_at, List<String> labels, Integer votes, List<Comment> comments, User author, User assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.closed_at = closed_at;
        this.labels = labels;
        this.votes = votes;
        this.comments = comments;
        this.author = author;
        this.assignee = assignee;
    }


    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getClosed_at() {

        return closed_at;
    }

    public void setClosed_at(String closed_at) {

        this.closed_at = closed_at;
    }

    public List<String> getLabels() {

        return labels;
    }

    public void setLabels(List<String> labels) {

        this.labels = labels;
    }

    public Integer getVotes() {

        return votes;
    }

    public void setVotes(Integer votes) {

        this.votes = votes;
    }

    public List<Comment> getComments() {

        return comments;
    }

    public void setComments(List<Comment> comments) {

        this.comments = comments;
    }

    public User getAuthor() {

        return author;
    }

    public void setAuthor(User author) {

        this.author = author;
    }

    public User getAssignee() {

        return assignee;
    }

    public void setAssignee(User assignee) {

        this.assignee = assignee;
    }

    public static Issue of(IssueParser issue, List<Comment> comments) {
        return new Issue(
                issue.getId().toString(),
                issue.getTitle(),
                issue.getBody(),
                issue.getState(),
                issue.getCreatedAt(),
                issue.getUpdatedAt(),
                issue.getClosedAt(),
                issue.getLabelNames(),
                issue.getTotalCount(),
                comments,
                issue.getAuthorModel(),
                issue.getAssigneeModel()


        );
    }
}
