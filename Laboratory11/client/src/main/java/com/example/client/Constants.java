package com.example.client;

public class Constants {
    public static final String GET_ALL_USERS = "localhost:9090/persons";
    public static final String GET_USER_BY_ID = "localhost:9090/persons/{id}";
    public static final String ADD_USER = "localhost:9090/users/";
    public static final String UPDATE_USER = "localhost:9090/users/{id}/";
    public static final String GET_ALL_FRIENDS = "localhost:9090/friendships";
    public static final String ADD_FRIENDSHIP = "localhost:9090/friendships/";
    public static final String GET_POPULAR_USERS = "localhost:9090/friendships/kfriends/{kFriends}";
}
