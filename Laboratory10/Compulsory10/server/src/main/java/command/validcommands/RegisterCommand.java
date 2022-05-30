package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class RegisterCommand implements ExecuteCommand {
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (args.size() == 0)
            return "Please provide an username!";

        if (clientUtil.isLoggedIn())
            return "You are already logged in.";

        return ServerUtil.INSTANCE.addUser(args.get(0));
    }
}
