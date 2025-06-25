package aiss.githubminer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import aiss.githubminer.Utils;
import aiss.githubminer.model.Comment;
import aiss.githubminer.model.commentParser.CommentParser;
import java.util.Arrays;
import java.util.List;
import java.util.SequencedCollection;

@Service
public class CommentService {

    @Value("https://api.github.com")
    private String defaultUri;

    @Autowired
    Utils utils;

   
    
    public List<Comment> getCommentsUrl(String uri) {
        ResponseEntity<CommentParser[]> response = utils.requestWithToken(uri, CommentParser[].class);
        return Arrays.stream(response.getBody()).map(Comment::of).toList();
    }

    public SequencedCollection<Comment> getCommentsfromIssues(String owner, String repo, Integer issueIndex) {
        String uri = defaultUri + "/repos/" + owner + "/" + repo +"/issues/" + issueIndex +"/comments";
        return getCommentsUrl(uri);
    }







}
