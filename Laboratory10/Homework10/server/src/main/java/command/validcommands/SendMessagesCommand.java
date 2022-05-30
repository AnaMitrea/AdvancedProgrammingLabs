package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;
import java.util.Set;

public class SendMessagesCommand implements ExecuteCommand {
    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (args.size() == 0)
            return "Please provide a message.";

        Set<String> friendList = ServerUtil.INSTANCE.getFriends().get(clientUtil.getUsername());

        StringBuilder message = new StringBuilder(" ");
        for (String item : args)
            message.append(item).append(" ");

        message = new StringBuilder(message.substring(0, message.length() - 1));
        System.out.println("[MESSAGE] " + message);

        StringBuilder result = new StringBuilder();
        for (String friend : friendList)
            result.append(ServerUtil.INSTANCE.sendMessage(friend, message.toString())).append("\n");

        return result.toString();
    }
}
