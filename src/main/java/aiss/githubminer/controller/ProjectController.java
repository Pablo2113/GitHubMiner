package aiss.githubminer.controller;

import aiss.githubminer.model.Project;
import aiss.githubminer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
public class ProjectController {

    @Autowired
    ProjectService projectService;

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
}
