package network.nodes;

import interfaces.Identifiable;
import java.util.Comparator;

/**
 * Method used for comparing two addresses of two Node objects.
 */
public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return ((Identifiable)o1).getAddress().compareTo(((Identifiable)o2).getAddress());
    }
}
