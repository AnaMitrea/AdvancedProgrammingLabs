import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private final String serverAddress;
    private final int PORT;

    public Client(String serverAddress, int port) {
        this.PORT = port;
        this.serverAddress = serverAddress;
    }

    /**
     * Available commands.
     */
    public void showCommands() {
        System.out.println("These are the valid commands:");
        System.out.println("1. Register - register <username>");
        System.out.println("2. Login - login <username>");
        System.out.println("3. Add Friends - friend <friend_username>");
        System.out.println("4. Send message to all friends - send <message>");
        System.out.println("5. Read all the messages - read");
        System.out.println("6. Logout - logout <username>");
        System.out.println("7. Exit (stops the client) - exit");
        System.out.println("8. Stop (stops the client & server) - stop");
        System.out.println("9. Create a SVG representation - create <title_img>");
        System.out.println("10. Upload a HTML representation - upload <title_img>");
        System.out.println("11. Determine the structural cohesion of the network - structural");
        System.out.println("12. Determine the density of the network - density");
        System.out.print("Enter command: ");
    }

    /**
     * Main method used to communicate with the server and to get the responses from it.
     */
    public void listen() {
        BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            showCommands();
            String command = standardInput.readLine();
            String response;
            while (!command.equals("exit")) {
                out.println(command);
                do {
                    response = in.readLine();
                    System.out.println(response);
                    if(response.equals("Server stopped!")) {
                        socket.close();
                        System.exit(1);
                    }
                } while (!response.equals(""));

                System.out.print("Enter command: ");
                command = standardInput.readLine();
            }
        } catch (UnknownHostException e) {
            System.err.println("[!] No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

