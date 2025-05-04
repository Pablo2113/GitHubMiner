package aiss.githubminer.service;

import aiss.githubminer.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Test
    void getProjectFromUrl() {
        Project project = projectService.getProjectFromUrl("https://api.github.com/repos/spring-projects/spring-framework",
                                                                11,20,3);
        System.out.println(project);
    }
}