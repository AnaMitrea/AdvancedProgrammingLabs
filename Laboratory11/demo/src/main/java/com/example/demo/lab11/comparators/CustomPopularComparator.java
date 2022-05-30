package com.example.demo.lab11.comparators;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class CustomPopularComparator implements Comparator<Map.Entry<Integer,  LinkedList<Integer>>> {

    @Override
    public int compare(Map.Entry<Integer, LinkedList<Integer>> o1, Map.Entry<Integer, LinkedList<Integer>> o2) {
        if(o1.getValue().size() == o2.getValue().size())
            return 0;
        else if(o1.getValue().size() < o2.getValue().size())
            return 1;
        else
            return -1;
    }
}
