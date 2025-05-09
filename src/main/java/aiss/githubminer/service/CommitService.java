package aiss.githubminer.service;


import aiss.githubminer.Utils;
import aiss.githubminer.model.Commit;
import aiss.githubminer.model.commitParser.CommitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {

    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;

    public List<Commit> getCommits(String uri) {
        ResponseEntity<CommitParser[]> response = utils.requestWithToken(uri, CommitParser[].class);
        List<Commit> commits = Arrays.stream(response.getBody()).map(Commit::of).toList();
        return commits;
    }





}