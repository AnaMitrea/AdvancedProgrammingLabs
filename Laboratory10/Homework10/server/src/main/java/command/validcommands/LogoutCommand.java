package command.validcommands;

import client.ClientUtil;

import java.util.List;

public class LogoutCommand implements ExecuteCommand {
    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (args.size() == 0)
            return "Please provide an username.";

        if (clientUtil.isLoggedIn()) {
            clientUtil.setLoggedIn(false);
            return "User logged out.";
        }

        return "You are not logged in!";
    }
}

