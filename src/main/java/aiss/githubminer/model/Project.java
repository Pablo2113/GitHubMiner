package aiss.githubminer.model;

import aiss.githubminer.model.projectParser.ProjectParser;

import java.util.List;

public class Project {
    public String id;
    public String name;
    public String web_url;

    public List<Commit> commits;
    public List<Issue> issues;

    public Project(String id, String name, String web_url, List<Commit> commits, List<Issue> issues) {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = commits;
        this.issues = issues;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public static Project of(ProjectParser projectData, List<Commit> commits, List<Issue> issues){
        return new Project(
                projectData.getId().toString(),
                projectData.getName(),
                projectData.getUrl(),
                commits,
                issues
        );
    }


}
