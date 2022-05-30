package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class ReadMessagesCommand implements ExecuteCommand {
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        if (!clientUtil.isLoggedIn())
            return "Please login first";

        return ServerUtil.INSTANCE.getMessages(clientUtil.getUsername());
    }
}
