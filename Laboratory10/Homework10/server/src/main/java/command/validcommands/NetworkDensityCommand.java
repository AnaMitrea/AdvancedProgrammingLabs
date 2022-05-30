package command.validcommands;

import client.ClientUtil;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import server.ServerUtil;

import java.util.List;
import java.util.Set;

public class NetworkDensityCommand implements ExecuteCommand {
    /**
     * Create an undirected graph using users and their friends
     * @return  graph
     */
    private DefaultUndirectedGraph<String, DefaultEdge> createGraph() {
        DefaultUndirectedGraph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (String user : ServerUtil.INSTANCE.getUsers()) {
            graph.addVertex(user);
        }

        for (String key : ServerUtil.INSTANCE.getFriends().keySet()) {
            Set<String> friends = ServerUtil.INSTANCE.getFriends().get(key);

            for (String friend : friends) {
                graph.addEdge(key, friend);
            }
        }
        return graph;
    }

    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        DefaultUndirectedGraph<String, DefaultEdge> graph = createGraph();
        int vertices = graph.vertexSet().size();
        int edges = graph.edgeSet().size();

        double potentialConections = (double)vertices * (vertices - 1) / 2;
        int actualConnections = edges;
        double density = (double)actualConnections / potentialConections;

        return "The social network density is " + density;
    }
}
