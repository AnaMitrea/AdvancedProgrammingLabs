package command.validcommands;

import client.ClientUtil;
import server.ServerUtil;

import java.util.List;

public class StopCommand implements ExecuteCommand {
    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    @Override
    public String executeCommand(List<String> args, ClientUtil clientUtil) {
        ServerUtil.INSTANCE.setAcceptRequests(false);

        return "Server stopped!";
    }
}
