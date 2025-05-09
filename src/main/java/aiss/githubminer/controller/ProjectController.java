package aiss.githubminer.controller;

import aiss.githubminer.model.Project;
import aiss.githubminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/github")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${gitminer_uri_post}")
    private String uriPost;

    @GetMapping("/{owner}/{repo}")
    public Project getProject(@RequestParam(defaultValue = "2") String sinceCommits,
                              @RequestParam(defaultValue = "20") String sinceIssues,
                              @RequestParam(defaultValue = "2") String maxPages,
                              @PathVariable String owner,
                              @PathVariable String repo
    ) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        Project project = projectService.getProjectFromUrl(url, Integer.parseInt(sinceCommits), Integer.parseInt(sinceIssues), Integer.parseInt(maxPages));
        return project;
    }

    @PostMapping("/{owner}/{repo}")
    public Project postProject(@RequestParam(defaultValue = "2") String sinceCommits,
                              @RequestParam(defaultValue = "20") String sinceIssues,
                              @RequestParam(defaultValue = "2") String maxPages,
                              @PathVariable String owner,
                              @PathVariable String repo
    ) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        Project project = projectService.getProjectFromUrl(url, Integer.parseInt(sinceCommits), Integer.parseInt(sinceIssues), Integer.parseInt(maxPages));
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Project> request = new HttpEntity<>(project, headers);
        ResponseEntity<Project> response = restTemplate.postForEntity(uriPost, request, Project.class);
        return response.getBody();
    }
}
