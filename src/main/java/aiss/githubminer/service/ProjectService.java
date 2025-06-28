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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

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

    public static String Date_DaysAgo(Integer i) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime since = now.minusDays(i);
        String sinceS =since.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        return sinceS;
    }

    public Project getProjectUrl(String url, Integer sinceCommits, Integer sinceIssues, Integer maxPages) {

        log.info("Starting project retrieval from URL: {}", url);
        log.info("Commits: {} days, Issues: {} , Max pages: {}", sinceCommits, sinceIssues, maxPages);

        String sIssues = Date_DaysAgo(sinceIssues);
        String sCommits = Date_DaysAgo(sinceCommits);

        log.info("Formatted dates -> Commits: {}, Issues: {}", sCommits, sIssues);

        ResponseEntity<ProjectParser> response = utils.requestWithToken(url, ProjectParser.class);
        ProjectParser projectParser = response.getBody();


        List<Commit> commit = new ArrayList<>();
        List<Issue> issues = new ArrayList<>();
        Integer cpageCount = 1;
        Integer spageCount = 1;
        Integer k = 30;

        log.info("Fetching commits...");
        while(maxPages>= cpageCount && k == 30){
            List<Commit> com = commitService.getCommi(projectParser.getUrl()+"/commits?page="+cpageCount+"&since"+sCommits);
            k = com.size();
            commit.addAll(com);
            cpageCount += 1;

            log.info("Page {}: {} commits fetched", cpageCount,k);
        }
        k = 30;

        log.info("Fetching issues...");
        while(maxPages>= spageCount && k == 30){
            List<Issue> issue = issueService.getIssueListUrl(projectParser.getUrl()+"/issues?page="+spageCount+"&since"+sIssues);
            k = issue.size();
            issues.addAll(issue);
            spageCount += 1;
            log.info("Page {}: {} issues fetched", spageCount, k);
        }

        log.info("Finished fetching data. Total commits: {}, Total issues: {}", commit.size(), issues.size());


        return Project.of(projectParser, commit , issues);

    }
}


