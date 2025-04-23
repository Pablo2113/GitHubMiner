package aiss.githubminer.service;



import aiss.githubminer.model.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {

    @Value("${github_uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    public List<Commit> getCommits(String owner, String repo) {
        String uri = baseUri + owner + "/" + repo + "/commits";
        return getCommits(uri);
    }

    public List<Commit> getCommitsT(String owner, String repo, String token) {
        String uri = baseUri+owner+"/"+repo+"/commits";
        return getCommits(uri, token);
    };

    public List<Commit> getCommits(String uri){
        Commit[] commits= restTemplate.getForObject(uri , Commit[].class);
        assert commits != null;
        return Arrays.stream(commits).toList();
    };

    public List<Commit> getCommitsT(String uri, String token){
        HttpHeaders headers = new HttpHeaders();
        // Setting tokken header
        headers.set("Authorization","Bearer " + token);
        // Send request
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        return List.of(response.getBody());
    };

    public List<Commit> getCommitsPag(String uri,String token,int page, int pageSize ){
        uri= uri+"commits?per_page="+pageSize+"&page="+page;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + token);
        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Commit[].class);
        return List.of(response.getBody());
    }
/*
    public List<Commit> getAllCommits(String owner, String repo, int sinceDays, int maxPages) throws HttpClientErrorException{
        List<Commit> commits = new ArrayList<>();

        LocalDateTime since = LocalDateTime.now().minusDays(sinceDays);

        String uri = baseUri + owner + "/" + repo + "/commits?since="+since;
        logger.debug()
    }
*/



}