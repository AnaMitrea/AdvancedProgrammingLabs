package command.validcommands;

import client.ClientUtil;

import java.util.List;

public interface ExecuteCommand {
    String executeCommand(List<String> args, ClientUtil clientUtil);
}

