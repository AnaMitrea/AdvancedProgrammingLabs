package server;

import client.ClientRunnable;
import command.CommandsList;
import command.validcommands.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8100;

    public Server() {
        CommandsList commandList = new CommandsList();

        RegisterCommand registerCommand = new RegisterCommand();
        LoginCommand loginCommand = new LoginCommand();
        LogoutCommand logoutCommand = new LogoutCommand();
        AddFriendCommand addFriendCommand = new AddFriendCommand();
        ReadMessagesCommand readMessagesCommand = new ReadMessagesCommand();
        SendMessagesCommand sendMessagesCommand = new SendMessagesCommand();

        commandList.add("register", registerCommand);
        commandList.add("login", loginCommand);
        commandList.add("logout", logoutCommand);
        commandList.add("friend", addFriendCommand);
        commandList.add("read", readMessagesCommand);
        commandList.add("send", sendMessagesCommand);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("[WAITING FOR CLIENT...]");
                Socket socket = serverSocket.accept();
                ClientRunnable clientRunnable = new ClientRunnable(socket, commandList, serverSocket.getLocalSocketAddress());
                new Thread(clientRunnable).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
