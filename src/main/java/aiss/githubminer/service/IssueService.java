package aiss.githubminer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.githubminer.Utils;
import aiss.githubminer.model.Comment;
import aiss.githubminer.model.Issue;
import aiss.githubminer.model.issueParser.IssueParser;
import java.util.ArrayList;
import java.util.List;


@Service
public class IssueService {

    @Value("https://api.github.com")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Utils utils;

    public Issue getIssuesfromUrl(String url) {
        ResponseEntity<IssueParser> response = utils.requestWithToken(url, IssueParser.class);
        IssueParser issueParser = response.getBody();
        List<Comment> comment = commentService.getCommentsUrl(issueParser.getCommentsUrl());
        return Issue.of(issueParser,comment);
    }


    public List<Issue> getIssueListUrl(String url) {
        ResponseEntity<IssueParser[]> response = utils.requestWithToken(url, IssueParser[].class);
        IssueParser[] issueParser = response.getBody();
        List<Issue> array = new ArrayList<>();
        for (IssueParser issueParser1 : issueParser) {
            List<Comment> comment = commentService.getCommentsUrl(issueParser1.getCommentsUrl());
            Issue issueToAdd = Issue.of(issueParser1, comment);
            array.add(issueToAdd);
        }
        return array;
    }


}
