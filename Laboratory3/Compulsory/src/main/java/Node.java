public abstract class Node implements Comparable<Node>{
    protected String name;

    abstract public String getName();

    abstract public void setName(String name);

    abstract public String toString();

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
