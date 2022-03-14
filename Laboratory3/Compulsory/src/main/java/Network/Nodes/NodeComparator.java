package Network.Nodes;

import Interfaces.Identifiable;
import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return ((Identifiable)o1).getAddress().compareTo(((Identifiable)o2).getAddress());
    }
}
