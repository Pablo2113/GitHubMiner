package aiss.githubminer.service;

import aiss.githubminer.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueServiceTest {
    @Autowired
    IssueService service;

    @Test
    void getIssueFromUrl() {
        Issue issue = service.getIssueFromUrl("https://api.github.com/repos/twilio/twilio-csharp/issues/491");
        System.out.println(issue);
    }
}