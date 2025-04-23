
package aiss.githubminer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sha",
    "node_id",
    "commit",
    "url",
    "html_url",
    "comments_url",
    "author",
    "committer",
    "parents"
})
public class Commit {

    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("commit")
    private Commit__1 commit;
    @JsonProperty("url")
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("author")
    private Author__1 author;
    @JsonProperty("committer")
    private Committer__1 committer;
    @JsonProperty("parents")
    private List<Parent> parents;

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("commit")
    public Commit__1 getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(Commit__1 commit) {
        this.commit = commit;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("author")
    public Author__1 getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author__1 author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public Committer__1 getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(Committer__1 committer) {
        this.committer = committer;
    }

    @JsonProperty("parents")
    public List<Parent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    // Método toString personalizado
    @Override
    public String toString() {
        return "SHA: " + sha + "\n" +
                "Node ID: " + nodeId + "\n" +
                "Commit: " + commit + "\n" +
                "URL: " + url + "\n" +
                "HTML URL: " + htmlUrl + "\n" +
                "Comments URL: " + commentsUrl + "\n" +
                "Author: " + author + "\n" +
                "Committer: " + committer + "\n" +
                "Parents: " + parents;
    }

}
