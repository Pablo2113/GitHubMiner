
package aiss.githubminer.model.commentParser;


    import com.fasterxml.jackson.annotation.JsonInclude;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "url",
        "html_url",
        "issue_url",
        "id",
        "node_id",
        "user",
        "created_at",
        "updated_at",
        "author_association",
        "body",
        "reactions",
        "performed_via_github_app"
    })

    public class CommentParser {

        @JsonProperty("url")
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("issue_url")
        private String issueUrl;
        @JsonProperty("id")
        private Long id;
        @JsonProperty("node_id")
        private String nodeId;
        @JsonProperty("user")
        private User user;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        @JsonProperty("author_association")
        private String authorAssociation;
        @JsonProperty("body")
        private String body;
        @JsonProperty("reactions")
        private Reactions reactions;
        @JsonProperty("performed_via_github_app")
        private Object performedViaGithubApp;

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

        @JsonProperty("issue_url")
        public String getIssueUrl() {
            return issueUrl;
        }

        @JsonProperty("issue_url")
        public void setIssueUrl(String issueUrl) {
            this.issueUrl = issueUrl;
        }

        @JsonProperty("id")
        public Long getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Long id) {
            this.id = id;
        }

        @JsonProperty("node_id")
        public String getNodeId() {
            return nodeId;
        }

        @JsonProperty("node_id")
        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        @JsonProperty("user")
        public User getUser() {
            return user;
        }

        @JsonProperty("user")
        public void setUser(User user) {
            this.user = user;
        }

        @JsonProperty("created_at")
        public String getCreatedAt() {
            return createdAt;
        }

        @JsonProperty("created_at")
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        @JsonProperty("updated_at")
        public String getUpdatedAt() {
            return updatedAt;
        }

        @JsonProperty("updated_at")
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        @JsonProperty("author_association")
        public String getAuthorAssociation() {
            return authorAssociation;
        }

        @JsonProperty("author_association")
        public void setAuthorAssociation(String authorAssociation) {
            this.authorAssociation = authorAssociation;
        }

        @JsonProperty("body")
        public String getBody() {
            return body;
        }

        @JsonProperty("body")
        public void setBody(String body) {
            this.body = body;
        }

        @JsonProperty("reactions")
        public Reactions getReactions() {
            return reactions;
        }

        @JsonProperty("reactions")
        public void setReactions(Reactions reactions) {
            this.reactions = reactions;
        }

        @JsonProperty("performed_via_github_app")
        public Object getPerformedViaGithubApp() {
            return performedViaGithubApp;
        }

        @JsonProperty("performed_via_github_app")
        public void setPerformedViaGithubApp(Object performedViaGithubApp) {
            this.performedViaGithubApp = performedViaGithubApp;
        }


        @Override
        public String toString() {
            return "CommentParser{}";
        }

        public aiss.githubminer.model.User getUserModel() {
            User user = this.getUser();

            return new aiss.githubminer.model.User(
                    user.getId().toString(),
                    user.getLogin(),
                    null,
                    user.getAvatarUrl(),
                    user.getUrl(),
                    user.getHtmlUrl(),
                    getUserModel().getFollowers()
            );
        }

    }
