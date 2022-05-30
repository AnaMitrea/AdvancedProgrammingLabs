package com.example.demo.lab11.service;

import com.example.demo.lab11.entity.Friendship;
import com.example.demo.lab11.repository.FriendshipRepository;
import com.example.demo.lab11.comparators.CustomFriendshipComparator;
import com.example.demo.lab11.comparators.CustomPopularComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<Friendship> getFriendships() {
        return friendshipRepository.findAll();
    }

    public void addNewFriendship(Friendship friendship) {
        try{
            if(friendship.getPersonId1().compareTo(friendship.getPersonId2()) == 0) {
                throw new IllegalStateException("A person cannot have a friendship with himself!");
            }

            if(friendship.getPersonId1().compareTo(0) < 0) {
                throw new IllegalStateException("Negative first person id!");
            } else if(friendship.getPersonId2().compareTo(0) < 0) {
                throw new IllegalStateException("Negative second person id!");
            }

            Optional<Friendship> friendshipOptional = friendshipRepository.findFriendshipById(friendship.getId());
            if(friendshipOptional.isPresent()) {
                throw new IllegalStateException("Friendship id already exists.");
            }
            friendshipRepository.save(friendship);

            Friendship inverted = new Friendship(friendship.getPersonId2(), friendship.getPersonId1());
            friendshipRepository.save(inverted);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void deleteFriendship(Integer friendshipId) {
        try {
            boolean exists = friendshipRepository.existsById(friendshipId);
            if(!exists) {
                throw new IllegalStateException("Friendship with id " + friendshipId + " does not exist.");
            }
            friendshipRepository.deleteById(friendshipId);
        } catch(IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateFriendship(Integer friendshipId, Integer personId1, Integer personId2) {
        try {
            Friendship friendship = friendshipRepository.findById(friendshipId)
                    .orElseThrow(() -> new IllegalStateException("Friendship with id " + friendshipId + " does not exist."));

            if (personId1 != null && personId1.compareTo(0) > 0 && !Objects.equals(friendship.getPersonId1(), personId1)) {
                friendship.setPersonId1(personId1);
            }

            if (personId2 != null && personId2.compareTo(0) > 0 && !Objects.equals(friendship.getPersonId2(), personId2)) {
                friendship.setPersonId2(personId2);
            }

        } catch(IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private  Map<Integer, LinkedList<Integer>> createFriendList(List<Friendship> allFriends) {
        Map<Integer, LinkedList<Integer>> friendsList = new HashMap<>();

        int currentId = allFriends.get(0).getPersonId1();
        LinkedList<Integer> friends = new LinkedList<>();

        for(Friendship friendship : allFriends) {
            if(friendship.getPersonId1() == currentId) {
                friends.add(friendship.getPersonId2());
            }
            else {
                friendsList.put(currentId, friends);
                currentId = friendship.getPersonId1();
                friends = new LinkedList<>();
                friends.add(friendship.getPersonId2());
            }
        }
        friendsList.put(currentId, friends);

        return friendsList;
    }

    public List<Map.Entry<Integer,  LinkedList<Integer>>> getKPopularPersons(Integer kFriends) {
        List<Friendship> allFriends = friendshipRepository.findAll();
        allFriends.sort(new CustomFriendshipComparator());

        List<Map.Entry<Integer,  LinkedList<Integer>>> list = new LinkedList<>( createFriendList(allFriends).entrySet() );
        list.sort(new CustomPopularComparator());

        for(int index = 0; index < list.size(); index++) {
            if (index >= kFriends) {
                list.remove(list.get(index));
                index--;
            }
        }
        return list;
    }

}
