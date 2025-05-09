package aiss.githubminer.service;

import aiss.githubminer.Utils;
import aiss.githubminer.model.Commit;
import aiss.githubminer.model.Issue;
import aiss.githubminer.model.Project;
import aiss.githubminer.model.projectParser.ProjectParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Utils utils;

    @Autowired
    CommitService commitService;

    @Autowired
    IssueService issueService;


    public static String DateXDaysAgo(Integer days){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime since = now.minusDays(days);
        String sinceString = since.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        return sinceString;


    }

    public Project getProjectFromUrl(String url, Integer sinceCommits, Integer sinceIssues, Integer maxPages){
        String sinceIssuesString = DateXDaysAgo(sinceIssues);
        String sinceCommitsString = DateXDaysAgo(sinceCommits);

        ResponseEntity<ProjectParser> response = utils.requestWithToken(url, ProjectParser.class);
        ProjectParser projectData = response.getBody();
        List<Commit> commitsAcc = new ArrayList<>();
        Integer commitPageCount = 1;
        List<Issue> issuesAcc = new ArrayList<>();
        Integer issuePageCount = 1;
        Integer lastSize = 30;

        while(maxPages>=commitPageCount && lastSize == 30){
            List<Commit> commits = commitService.getCommits(projectData.getUrl()+"/commits?page="+commitPageCount+"&since="+sinceCommitsString);
            lastSize = commits.size();
            commitsAcc.addAll(commits);
            commitPageCount++;
        }
        lastSize = 30;
        while(maxPages>=issuePageCount && lastSize == 30){
            List<Issue> issues = issueService.getIssueListFromUrl(projectData.getUrl()+"/issues?page="+issuePageCount+"&since="+sinceIssuesString);
            lastSize = issues.size();
            issuesAcc.addAll(issues);
            issuePageCount++;
        }

        return Project.of(projectData, commitsAcc, issuesAcc);

    }


}
