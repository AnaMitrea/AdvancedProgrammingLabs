package com.example.client;

import com.example.client.model.User;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.example.client.Constants.*;

public class RestClient {
    private WebClient webClient;

    public RestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<User> getAllUsers() {
        return webClient.get().uri( GET_ALL_USERS)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }

    public User getUserById(int id) {
        return webClient.get().uri(GET_USER_BY_ID, id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public void addUser(User user) {
        webClient.post().uri(ADD_USER)
                .bodyValue(user);
    }

    public void updateUser(int id, User user) {
        webClient.put().uri(UPDATE_USER, id);
    }

    public void deleteUserById(int id) {
        webClient.delete().uri(GET_USER_BY_ID,id);
    }

    public List<User> getFriends(int userId) {
        return webClient.get().uri(GET_ALL_FRIENDS, userId)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }

    public void addFriendship(int userId, int friendId) {
        webClient.post().uri(ADD_FRIENDSHIP, userId)
                .bodyValue(friendId);
    }

    public List<User> getPopularUser(int k) {
        return webClient.get().uri(GET_POPULAR_USERS, k)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }
}
