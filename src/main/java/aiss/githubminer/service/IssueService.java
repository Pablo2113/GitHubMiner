package aiss.githubminer.service;

import aiss.githubminer.Utils;
import aiss.githubminer.model.Issue;
import aiss.githubminer.model.issueParser.IssueParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssueService {
    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Utils utils;

    public Issue getIssueFromUrl(String uri){
        ResponseEntity<IssueParser> response = utils.requestWithToken(uri, IssueParser.class);
        //TODO: manejo de excepciones
        IssueParser issue = response.getBody();
        return Issue.of(issue);
    }
}
