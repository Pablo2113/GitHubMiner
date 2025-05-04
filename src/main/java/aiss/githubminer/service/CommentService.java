package aiss.githubminer.service;

import aiss.githubminer.Utils;
import aiss.githubminer.model.Comment;
import aiss.githubminer.model.commentParser.CommentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {
    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Utils utils;

    public List<Comment> getCommentFromIssue(String owner, String repo, Integer issueNumber){
        String uri =  baseUri + "/repos/" + owner + "/" + repo + "/issues/" + issueNumber + "/comments";
        return getComments(uri);
    }

    public List<Comment> getComments(String uri) {
        ResponseEntity<CommentParser[]> response = utils.requestWithToken(uri, CommentParser[].class);
        return Arrays.stream(response.getBody()).map(Comment::of).toList();
    }


}
