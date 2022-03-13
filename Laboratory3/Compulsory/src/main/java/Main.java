public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Node v1 = new Computer("v1", "14.8.100.105",8);
        Node v2 = new Router("v2","201.215.143.255");
        Node v3 = new Switch("v3","56.18.89.220");
        Node v4 = new Switch("v4","14.238.246.51");
        Node v5 = new Router("v5","245.212.14.137");
        Node v6 = new Computer("v6","177.122.47.180",16);

        network.addNode(v1);
        network.addNode(v4);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v6);
        network.addNode(v5);

        System.out.println(network.toString());
    }
}
