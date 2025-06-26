package aiss.githubminer.controller;

import aiss.githubminer.model.Project;
import aiss.githubminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/gitgub")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    RestTemplate restTemplate;

    @Value("&{gitminer_uri}")
    private String uri;

    @GetMapping("/{owner}/{repo}")
    public Project getProject(@RequestParam(defaultValue = "2") String sinceCommits,
                              @RequestParam(defaultValue = "20") String sinceIssues,
                              @RequestParam(defaultValue = "2") String maxPages,
                              @PathVariable String owner,
                              @PathVariable String repo) {
    String url = "https://api.github.com/repos/" + owner + "/" + repo;
    Project project = projectService.getProjectUrl( url, Integer.parseInt(sinceCommits), Integer.parseInt(sinceIssues), Integer.parseInt(maxPages));
    return project;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{owner}/{repo}")
    public Project createProject(@RequestParam(defaultValue = "2") String sinceCommits,
                                 @RequestParam(defaultValue = "20") String sinceIssues,
                                 @RequestParam(defaultValue = "2") String maxPages,
                                 @PathVariable String owner,
                                 @PathVariable String repo){
        String url = "https://api.github.com/repos/" + owner + "/" + repo;
        Project project = projectService.getProjectUrl(url, Integer.parseInt(sinceCommits), Integer.parseInt(sinceIssues), Integer.parseInt(maxPages));
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Project> entity = new HttpEntity<>(project, headers);
        ResponseEntity<Project> response = restTemplate.postForEntity(uri, entity, Project.class);
        return response.getBody();

    }

}
