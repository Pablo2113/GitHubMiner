package aiss.githubminer.service;

import aiss.githubminer.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {
    @Autowired
    private IssueService service;

    @Test
    void getIssueFromUrl() {
        Issue issue = service.getIssueFromUrl("https://api.github.com/repos/twilio/twilio-csharp/issues/491");
        System.out.println(issue);
    }

    @Test
    void getIssueListFromUrl() {
        List<Issue> issues = service.getIssueListFromUrl("https://api.github.com/repos/twilio/twilio-csharp/issues");
        issues.stream().map(Issue::getAuthor).forEach(System.out::println);
    }
}