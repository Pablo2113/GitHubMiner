package aiss.githubminer.service;


import aiss.githubminer.model.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class CommitServiceTest {

    @Value("${github_token}")
    private String token;

    @Autowired
    CommitService service;

    @Test
    void getCommits() {
        List<Commit> commits = service.getCommits("https://api.github.com/repos/spring-projects/spring-framework/commits");
        commits.stream().map(Commit::getMessage).forEach(System.out::println);
    }

}