import Dijkstra.Dijkstra;
import Network.*;
import Network.Nodes.*;

public class Homework {
    public static void main(String[] args) {
        Node v1 = new Computer("v1", "14.8.100.105",10);
        Node v2 = new Router("v2","201.215.143.255");
        Node v3 = new Switch("v3");
        Node v4 = new Switch("v4");
        Node v5 = new Router("v5","245.212.14.137");
        Node v6 = new Computer("v6","177.122.47.180",8);

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v1,10);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v1,50);
        v3.setCost(v2,20);
        v3.setCost(v4,10);
        v4.setCost(v2,20);
        v4.setCost(v3,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v2,20);
        v5.setCost(v4,30);
        v5.setCost(v6,20);
        v6.setCost(v4,10);
        v6.setCost(v5,20);

        Network network = new Network();
        network.addNode(v1);
        network.addNode(v4);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v6);
        network.addNode(v5);

        System.out.println(network);
        System.out.print("Only sorted identifiable: ");
        network.printSortedIdentifiable();

        Dijkstra dijkstra = new Dijkstra();
        network = dijkstra.calculateShortestPathFromSource(network, v3);

        System.out.println("Costs from " + v3.getName() + ": ");
        dijkstra.printPathsAndCosts(network, v3);
    }
}
