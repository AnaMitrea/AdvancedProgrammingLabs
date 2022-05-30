package command.validcommands;

import client.ClientUtil;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import server.ServerUtil;

import java.util.List;
import java.util.Set;

public class StructuralCohesionCommand implements ExecuteCommand {

    /**
     * 1. Split each node v in the graph into to nodes: v_in and v_out.<br>
     * 2. For each node v, add an edge of capacity one from v_in to v_out.<br>
     * 3. Replace each other edge (u, v) in the graph with an edge from u_out to v_in of capacity 1. <br>
     * 4. Add in a new dedicated destination node t.<br>
     * 5. For each of the target nodes v, add an edge from v_in to destination with capacity 1.<br>
     * @return  The Directed graph
     */
    private DefaultDirectedGraph<String, DefaultEdge> createGraph() {
        DefaultDirectedGraph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        for (String user : ServerUtil.INSTANCE.getUsers()) {
            graph.addVertex(user + "_in");
            graph.addVertex(user + "_out");
            graph.addEdge(user + "_in", user + "_out");
        }

        for (String key : ServerUtil.INSTANCE.getFriends().keySet()) {
            Set<String> friends = ServerUtil.INSTANCE.getFriends().get(key);

            for (String friend : friends) {
                graph.addEdge(key + "_out", friend + "_in");
            }
        }

        graph.addVertex("destination");
        for (String user : ServerUtil.INSTANCE.getUsers()) {
            graph.addEdge(user + "_in", "destination");
        }
        return graph;
    }

    /**
     * 6. Find a max-flow from s_out to destination. The value of the flow is the number of node-disjoint paths
     * @param args  arguments
     * @param clientUtil   current client state
     * @return  response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        DefaultDirectedGraph<String, DefaultEdge> graph = createGraph();

        int minimum = graph.vertexSet().size();
        for (String user : ServerUtil.INSTANCE.getUsers()) {
            int value = maximumFlow(user + "_out", "destination", graph);
            minimum = Math.min(minimum, value);
        }
        return String.valueOf(minimum);
    }

    /**
     * Computes maximum flow from a graph using Edmonds-Karp algorithm.
     * @param source    Source Vertex
     * @param destination   Destination Vertex
     * @param graph         Graph
     * @return          Result
     */
    private int maximumFlow(String source, String destination, DefaultDirectedGraph<String, DefaultEdge> graph) {
        EdmondsKarpMFImpl<String, DefaultEdge> alg = new EdmondsKarpMFImpl<>(graph);
        double result = alg.getMaximumFlowValue(source, destination);
        return (int) result;
    }
}
