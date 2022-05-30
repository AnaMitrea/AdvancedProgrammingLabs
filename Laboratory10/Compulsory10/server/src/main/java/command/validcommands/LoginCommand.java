package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class LoginCommand implements ExecuteCommand {
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        List<String> globalStateUsers = ServerUtil.INSTANCE.getUsers();

        if (args.size() == 0)
            return "Please provide an username.";

        if (clientUtil.isLoggedIn())
            return "You are already logged in!";

        if (globalStateUsers.contains(args.get(0))) {
            clientUtil.setLoggedIn(true);
            clientUtil.setUserName(args.get(0));
            return "Logged in successfully.";
        }

        return "Logged in failed. User does not exists.";
    }
}