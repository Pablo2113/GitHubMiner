package aiss.githubminer.service;

import aiss.githubminer.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
    void getIssueWithAsiggneeFromUrl() { //Este test solo es ejecutable si el token tiene permisos de lectura del repositorio, en el enlace hay un issue que tiene un asignee y no he econtrado más
        Issue issue = service.getIssueFromUrl("https://api.github.com/repos/Esteban-Panes-Mendoza/GITHUBMINER/issues/3");
        System.out.println(issue);
    }

    @Test
    void getIssueListFromUrl() {
        List<Issue> issues = service.getIssueListFromUrl("https://api.github.com/repos/twilio/twilio-csharp/issues");
        issues.stream().map(Issue::getAuthor).forEach(System.out::println);
    }
}