package aiss.githubminer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Utils {

    @Value("${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}")
    private String token;

    @Autowired
    RestTemplate restTemplate;



    public <K> ResponseEntity<K> requestWithToken(String uri, Class<K> classType){
        HttpHeaders headers = new HttpHeaders();
        if(token.length() > 0){
            headers.set("Authorization","Bearer " + token);
        }
        HttpEntity<K> request = new HttpEntity<>(null, headers);
        ResponseEntity<K> response = restTemplate.exchange(uri, HttpMethod.GET, request, classType);
        return response;


    }
}
