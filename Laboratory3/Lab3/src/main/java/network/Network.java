package network;

import network.nodes.Computer;
import network.nodes.Node;
import network.nodes.NodeComparator;
import network.nodes.Router;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
        nodes.sort(Node::compareTo);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.print("Locations are: ");
        for (Node node : this.nodes) {
            sb.append(node.toString());
        }
        return sb.toString();
    }

    public void printSortedIdentifiable() {
        List<Node> identifiableNodes = new ArrayList<>();
        for (Node node : this.nodes) {
            if(node instanceof Computer || node instanceof Router) {
                identifiableNodes.add(node);
            }
        }
        identifiableNodes.sort(new NodeComparator());
        System.out.println(identifiableNodes);
    }
}
