package com.example.client;

import com.example.client.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClientApplicationTests {

    private static final String URL = "localhost:9090";
    private WebClient webClient = WebClient.create();

    RestClient restClient = new RestClient(webClient);

    @Test
    void getAllUsers() {
        List<User> userList = restClient.getAllUsers();
        System.out.println("userList : " + userList );
        assertTrue(userList.size() > 0);
    }

    @Test
    void getUserById() {
        int id = 3;
        User user = restClient.getUserById(id);
        assertEquals("Jennifer Stew", user.getName());
    }

    @Test
    void addUser() {
        User user = new User(4, "user4");
        restClient.addUser(user);
    }

    @Test
    void updateUser() {
        User updateUser = restClient.getUserById(3);
        updateUser.setName("Marioara");
        restClient.updateUser(3, updateUser);
    }

    @Test
    void deleteUserById() {
        restClient.deleteUserById(4);
    }

    @Test
    void getFriends() {
        restClient.getFriends(1);
    }

    @Test
    void addFriendship() {
        User friend = restClient.getUserById(4);
        System.out.println(friend);
        restClient.addFriendship(1, friend.getId());
    }

    @Test
    void getPopularUser() {
        int k=2;
        List<User> popular = restClient.getPopularUser(k);
        System.out.println(popular);
    }
}
