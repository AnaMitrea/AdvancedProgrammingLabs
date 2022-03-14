package dijkstra;

import network.Network;
import network.nodes.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    /**
     * The method is used to find the lowest cost of a node in the list of unknown cost nodes.
     * @param unknownCostNodes     The list of nodes whose minimum costs (from starting node) are not yet known.
     * @return                     The node which has the lowest distance from the unknownCostNodes list.
     */
    public Node getLowestDistanceNode(List<Node> unknownCostNodes) {
        Node lowestCostNode = null;
        int lowestCost = Integer.MAX_VALUE;

        for(Node node : unknownCostNodes) {
            int dist = node.getDistance();
            if(dist < lowestCost) {
                lowestCost = dist;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    /**
     * The method is used to calculate the minimum distance between two nodes by comparing the actual distance with the new calculated one on the path.
     * @param inputNode     The nodes which is currently evaluated.
     * @param edgeCost      The cost between the source node and the evaluated node.
     * @param sourceNode    The source node.
     */
    public void getMinimumDistance(Node inputNode, Integer edgeCost, Node sourceNode) {
        Integer sourceDist = sourceNode.getDistance();

        if((sourceDist + edgeCost) < inputNode.getDistance()) {
            inputNode.setDistance(sourceDist + edgeCost);

            LinkedList<Node> shortestPath = new LinkedList<>(inputNode.getShortestPath());
            shortestPath.add(sourceNode);
            inputNode.setShortestPath(shortestPath);
        }
    }

    /**
     * The method is used to calculate all the pairs source node-final node which has the shortest path between them.
     *
     * @param network       The given network seen as a graph.
     * @param source        The source node which the algorithm starts first.
     * @return              The modified network containing the nodes with the shortest paths between all of them.
     */
    public Network calculateShortestPathFromSource(Network network, Node source) {
        source.setDistance(0);
        List<Node> knownCostNodes = new ArrayList<>();
        List<Node> unknownCostNodes = new ArrayList<>();

        unknownCostNodes.add(source);

        while(unknownCostNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unknownCostNodes);
            unknownCostNodes.remove(currentNode);

            for(Map.Entry<Node,Integer> adj : currentNode.getCost().entrySet()) {
                Node adjNode = adj.getKey();
                int value = adj.getValue();

                if(!knownCostNodes.contains(adjNode)) {
                    getMinimumDistance(adjNode,value,currentNode);
                    unknownCostNodes.add(adjNode);
                }
            }
            knownCostNodes.add(currentNode);
        }
        return network;
    }

    /**
     * The method is used to print all the paths and costs between the startingNode and all the other nodes in the network.
     * @param network       The given network (graph).
     * @param startingNode  The starting node used first in the dijkstra algorithm.
     */
    public void printPathsAndCosts(Network network, Node startingNode) {
        for(Node node : network.getNodes()) {
            if(node != startingNode) {
                int distance = node.getDistance();
                System.out.println(startingNode.getName() + "--" + node.getName() + " : " + distance);
            }
        }
    }
}
