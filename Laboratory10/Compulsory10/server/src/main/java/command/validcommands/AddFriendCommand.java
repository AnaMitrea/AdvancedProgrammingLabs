package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class AddFriendCommand implements ExecuteCommand {
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (args.size() == 0)
            return "Please provide a friend name!";

        if (!clientUtil.isLoggedIn())
            return "Please login first.";

        String from = clientUtil.getUsername();

        StringBuilder result = new StringBuilder();
        for (String newFriend : args)
            result.append(ServerUtil.INSTANCE.addFriend(from, newFriend)).append("\n");

        if (result.length() > 0)
            result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }
}
