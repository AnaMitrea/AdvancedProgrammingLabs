public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Node v1 = new Computer("v1", "addr1",8);
        Node v2 = new Router("v2","addr2");
        Node v3 = new Switch("v3","addr3");
        Node v4 = new Switch("v4","addr4");
        Node v5 = new Router("v5","addr5");
        Node v6 = new Computer("v6","addr6",16);

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        System.out.print("Locations are: ");
        for(Node node : network.getNodes()) {
            System.out.print(node.toString());
        }
        System.out.println();
    }
}
