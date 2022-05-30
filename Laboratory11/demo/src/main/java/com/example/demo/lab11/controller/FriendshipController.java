package com.example.demo.lab11.controller;

import com.example.demo.lab11.entity.Friendship;
import com.example.demo.lab11.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/friendships")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @GetMapping
    public List<Friendship> getFriendships() {
        return friendshipService.getFriendships();
    }

    @GetMapping(path = "/kfriends/{kFriends}")
    public List<Map.Entry<Integer,  LinkedList<Integer>>> getKPopularPersons(@PathVariable Integer kFriends) {
        return friendshipService.getKPopularPersons(kFriends);
    }

    @PostMapping
    public void registerNewRelationship(@RequestBody Friendship friendship) {
        friendshipService.addNewFriendship(friendship);

        Integer temp = friendship.getPersonId1();
        friendship.setPersonId1(friendship.getPersonId2());
        friendship.setPersonId2(temp);
        friendshipService.addNewFriendship(friendship);
    }

    @PutMapping(path = "{friendshipId}")
    public void updateFriendship(
            @PathVariable("friendshipId") Integer friendshipId,
            @RequestParam(required = false) Integer personId1,
            @RequestParam(required = false) Integer personId2) {
        friendshipService.updateFriendship(friendshipId, personId1, personId2);
    }

    @DeleteMapping(path = "{friendshipId}")
    public void deletePerson(@PathVariable("friendshipId") Integer friendshipId) {
        friendshipService.deleteFriendship(friendshipId);
    }
}
