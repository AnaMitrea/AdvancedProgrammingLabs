package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class ReadMessagesCommand implements ExecuteCommand {
    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (!clientUtil.isLoggedIn())
            return "Please login first";

        return ServerUtil.INSTANCE.getMessages(clientUtil.getUsername());
    }
}
