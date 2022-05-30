package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public enum ServerUtil {
    INSTANCE;
    private List<String> users = new ArrayList<>();
    private Map<String, Set<String>> friends = new HashMap<>();
    private Map<String, List<String>> messages = new HashMap<>();

    ServerUtil() {
        loadUsersFromFile("src/main/resources/users_list.txt");
        loadFriendsFromFile("src/main/resources/friends_list.txt");
        loadMessagesFromFile("src/main/resources/messages.txt");
    }

    private void loadUsersFromFile(String path) {
        try {
            Scanner reader = new Scanner(new File(path));

            while (reader.hasNextLine()) {
                String user = reader.nextLine();
                if (!user.equals("")) {
                    users.add(user);
                    friends.put(user, new LinkedHashSet<>());
                    messages.put(user, new LinkedList<>());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadFriendsFromFile(String path) {
        try {
            Scanner reader = new Scanner(new File(path));

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                List<String> friendsAssociation = List.of(line.split(" "));

                friends.get(friendsAssociation.get(0)).add(friendsAssociation.get(1));
                friends.get(friendsAssociation.get(1)).add(friendsAssociation.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadMessagesFromFile(String path) {
        try {
            Scanner reader = new Scanner(new File(path));

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (!line.equals("")) {
                    List<String> message = new LinkedList<>(Arrays.asList(line.split(" ", 2)));

                    String toList = message.get(0);
                    String text = message.get(1);

                    String[] to = toList.split(",");
                    for (String receiver : to) {
                        messages.get(receiver).add(text);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String addUser(String user) {
        if (users.contains(user))
            return "user already exists";

        Path path = Paths.get("src/main/resources/users_list.txt");

        try {
            Files.write(path, (user + "\n").getBytes(), StandardOpenOption.APPEND);  //Append mode
            users.add(user);
            friends.put(user,new LinkedHashSet<>());
            messages.put(user,new LinkedList<>());

            return "user successfully added";
        } catch (IOException e) {
            return "error on adding user.";
        }
    }

    public String addFriend(String user1, String user2) {
        if (!(users.contains(user1) && users.contains(user2)))
            return user1 + " or " + user2 + " does not exists.";

        Path path = Paths.get("src/main/resources/friends_list.txt");
        try {
            Files.write(path, (user1 + " " + user2 + "\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (user2 + " " + user1 + "\n").getBytes(), StandardOpenOption.APPEND);

            friends.get(user1).add(user2);
            friends.get(user2).add(user1);

            return "friendship relation added";
        } catch (IOException e) {
            return "error on adding the friendship relation.";
        }
    }

    public String getMessages(String userName) {
        StringBuilder result = new StringBuilder(new StringBuilder());

        if (!users.contains(userName))
            return "invalid username";

        List<String> userMessages = messages.get(userName);

        for (String message : userMessages)
            result.append(message).append("\n");

        if (result.length() > 0)
            result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }

    public String sendMessage(String to, String message) {
        if (!users.contains(to))
            return "user does not exists.";

        messages.get(to).add(message);

        return "message sent to " + to;
    }

    // Setters & getters
    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Map<String, Set<String>> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, Set<String>> friends) {
        this.friends = friends;
    }

    public Map<String, List<String>> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, List<String>> messages) {
        this.messages = messages;
    }
}
