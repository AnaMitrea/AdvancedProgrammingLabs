package server;

import client.ClientRunnable;
import command.CommandsList;
import command.validcommands.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8100;

    private CommandsList createCommandList() {
        CommandsList commandList = new CommandsList();
        commandList.add("register", new RegisterCommand());
        commandList.add("login",  new LoginCommand());
        commandList.add("logout", new LogoutCommand());
        commandList.add("friend", new AddFriendCommand());
        commandList.add("read", new ReadMessagesCommand());
        commandList.add("send", new SendMessagesCommand());
        commandList.add("create", new CreateSvgCommand());
        commandList.add("upload", new UploadHtmlCommand());
        commandList.add("stop", new StopCommand());
        commandList.add("structural", new StructuralCohesionCommand());
        commandList.add("density", new NetworkDensityCommand());
        return commandList;
    }

    public Server() {
        CommandsList commandList = createCommandList();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                if(!ServerUtil.INSTANCE.getAcceptRequests()) {
                    break;
                }
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
