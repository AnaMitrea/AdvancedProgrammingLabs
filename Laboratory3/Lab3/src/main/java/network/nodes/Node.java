package network.nodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Node implements Comparable<Node>{
    protected String name;
    protected Map<Node,Integer> cost = new HashMap<>();
    protected List<Node> shortestPath = new LinkedList<>();
    protected Integer distance = Integer.MAX_VALUE;

    abstract public String getName();
    abstract public void setName(String name);

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    abstract public String toString();

    public void setCost(Node key, int value) {
        cost.put(key, value);
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
