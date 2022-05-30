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

    public void showCommands() {
        System.out.println("These are the valid commands:");
        System.out.println("1. Register - register <username>");
        System.out.println("2. Login - login <username>");
        System.out.println("3. Add Friend (Needs to be logged in!)- friend <friend_username>");
        System.out.println("4. Send message to all friends - send <message>");
        System.out.println("5. Read all the messages - read");
        System.out.println("6. Logout - logout <username>");
        System.out.println("7. Exit (stops the client) - exit");
        System.out.println("8. Stop (stops the client & server) - stop");
        System.out.print("Enter command: ");
    }

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
                    if(response.equals("Server stopped.")) {
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

