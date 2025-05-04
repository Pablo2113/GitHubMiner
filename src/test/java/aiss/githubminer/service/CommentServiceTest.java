package aiss.githubminer.service;

import aiss.githubminer.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Value("${github_token}")
    private String token;

    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    private CommentService service;


    @Test
    void getCommentFromIssue() {
        List<Comment> response = service.getCommentFromIssue("twilio", "twilio-python",852);
        response.stream().forEach(System.out::println);
    }
}