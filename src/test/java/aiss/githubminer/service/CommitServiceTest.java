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


//    @DisplayName("Get the commits of a repo (no pagination)")
//    void getCommitsNoPagination() {
//        List<Commit> commits=service.getCommits("spring-projects","spring-framework");
//        assertNotNull(commits);
//        assertTrue(commits.size()==30, "the list of commits is empty");
//        System.out.println("-".repeat(200));
//        System.out.println(commits.get(0));
//        System.out.println("-".repeat(200));
//
//    }
//
//
//    @Test
//    @DisplayName("Get the commits of https://api.github.com/repos/spring-projects/spring-framework/commits")
//    void getCommit() {
//        List<Commit> commits = service.getCommitsT("https://api.github.com/repos/spring-projects/spring-framework/commits", token);
//        if(commits == null) System.out.println("No commits found");
//        else commits.stream().forEach(System.out::println);
//
//    }
//
//    @Test
//    @DisplayName("Get commits from https://github.com/spring-projects/spring-framework in 3 pages of size 5")
//    void getCommitsPag() {
//        String uri="https://api.github.com/repos/spring-projects/spring-framework/";
//        List<Commit> commits = service.getCommitsPag(uri,token,3,5);
//        AtomicInteger i= new AtomicInteger();
//        commits.stream().forEach(x->System.out.println(i.getAndIncrement() + "   " +x));
//    }
//
//    @Test
//    @DisplayName("Get commits of project")
//    void getCommits() {
//        List<Commit> lista = service.getCommits("spring-projects","spring-framework");
//        lista.stream().forEach(System.out::println);
//    }
}