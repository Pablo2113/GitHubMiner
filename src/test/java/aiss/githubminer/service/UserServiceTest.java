package aiss.githubminer.service;

import aiss.githubminer.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void getUsers() {
        List<User> users = service.getUsers();
        users.stream().map(User::getUsername).forEach(System.out::println);
    }

    @Test
    void getUserById() {
        User user = service.getUserByUsername("torvalds");
        assertNotNull(user,"El usuario no existe");
        assertEquals("Linus Torvalds", user.getName(), "El usuario no es el correcto");
    }
}