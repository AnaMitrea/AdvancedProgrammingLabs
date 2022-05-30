package command.validcommands;

import client.ClientUtil;

import java.util.List;

public interface ExecuteCommand {
    /**
     * Method that executed the current command.
     * @param args  Arguments
     * @param clientUtil    Current client state
     * @return  Response
     */
    String executeCommand(List<String> args, ClientUtil clientUtil);
}

