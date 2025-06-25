package aiss.githubminer.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import aiss.githubminer.Utils;
import aiss.githubminer.model.Commit;
import aiss.githubminer.model.commitParser.CommitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Service
public class CommitService {

    @Value("https://api.github.com")
    private String apiUrl;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Utils utils;


    public List<Commit> getCommi(String uri) {
        ResponseEntity<CommitParser[]> response = utils.requestWithToken(uri, CommitParser[].class);
        List<Commit> commit = Arrays.stream(response.getBody()).map(Commit::of).toList();
        return commit;
    }


}
