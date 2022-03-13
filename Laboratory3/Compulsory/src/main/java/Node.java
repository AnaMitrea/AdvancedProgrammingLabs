import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node>{
    protected String name;
    protected Map<Node,Integer> cost = new HashMap<>();

    abstract public String getName();
    abstract public void setName(String name);
    abstract public String toString();

    public void setCost(Node node,int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
