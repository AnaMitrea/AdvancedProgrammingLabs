package com.example.demo.lab11.comparators;

import com.example.demo.lab11.entity.Friendship;

import java.util.Comparator;


public class CustomFriendshipComparator implements Comparator<Friendship> {

    @Override
    public int compare(Friendship o1, Friendship o2) {
        return Integer.compare(o1.getPersonId1(), o2.getPersonId1());
    }
}
