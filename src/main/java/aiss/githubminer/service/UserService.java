package aiss.githubminer.service;


import aiss.githubminer.model.User;
import aiss.githubminer.model.userParser.UserParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Value("${github_uri}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getUsers() {
        UserParser[] usersData = restTemplate.getForObject(url + "/users", UserParser[].class);
        List<User> users = Arrays.stream(usersData).map(User::of).toList();
        return users;
    }

    public User getUserByUsername(String username) {
        UserParser userData = restTemplate.getForObject(url + "/users/" + username, UserParser.class);
        return User.of(userData);
    }

}



