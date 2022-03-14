import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    public Node getLowestDistanceNode(List<Node> unvisitedNodes) {
        Node lowestCostNode = null;
        int lowestCost = Integer.MAX_VALUE;

        for(Node node : unvisitedNodes) {
            int dist = node.getDistance();
            if(dist < lowestCost) {
                lowestCost = dist;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    public void getMinimumDistance(Node inputNode, Integer edgeCost, Node sourceNode) {
        Integer sourceDist = sourceNode.getDistance();

        if((sourceDist + edgeCost) < inputNode.getDistance()) {
            inputNode.setDistance(sourceDist + edgeCost);

            LinkedList<Node> shortestPath = new LinkedList<>(inputNode.getShortestPath());
            shortestPath.add(sourceNode);
            inputNode.setShortestPath(shortestPath);
        }
    }

    public Network calculateShortestPathFromSource(Network network, Node source) {
        source.setDistance(0);
        List<Node> visitedNodes = new ArrayList<>();
        List<Node> unvisitedNodes = new ArrayList<>();

        unvisitedNodes.add(source);

        while(unvisitedNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unvisitedNodes);
            unvisitedNodes.remove(currentNode);

            for(Map.Entry<Node,Integer> adj : currentNode.getCost().entrySet()) {
                Node adjNode = adj.getKey();
                int value = adj.getValue();

                if(!visitedNodes.contains(adjNode)) {
                    getMinimumDistance(adjNode,value,currentNode);
                    unvisitedNodes.add(adjNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return network;
    }

    public void printPathsAndCosts(Network network, Node startingNode) {
        for(Node node : network.getNodes()) {
            if(node != startingNode) {
                int distance = node.getDistance();
                System.out.println(startingNode.getName() + "--" + node.getName() + " : " + distance);
            }
        }
    }
}
