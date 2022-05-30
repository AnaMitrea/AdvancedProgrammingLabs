package client;

import command.Command;
import command.CommandsList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientRunnable implements Runnable {
    public Socket socket;
    public SocketAddress socketAddress;
    public CommandsList commandList;

    public ClientRunnable(Socket socket, CommandsList commandList, SocketAddress socketAddress) {
        this.socket = socket;
        this.commandList = commandList;
        this.socketAddress = socketAddress;
    }

    @Override
    public void run() {
        ClientUtil clientState = new ClientUtil();
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("[REQUEST] " + request);
                Command command = new Command(request);

                if (command.getName().equals("stop")) {
                    response = "Server stopped.";
                    out.println(response);
                    out.flush();
                    socket.close();
                    System.exit(1);
                }

                response = commandList.runCommand(command, clientState);
                System.out.println("[RESPONSE] " + response);

                String[] responseLines = response.split("\n");

                for (String line : responseLines) {
                    out.println(line);
                    out.flush();

                    System.out.println("[SENT] " + line);
                }
                out.println("");
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}

