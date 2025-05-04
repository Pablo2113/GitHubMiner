package aiss.githubminer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {

    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;


}
