package command;

import client.ClientUtil;
import command.validcommands.ExecuteCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandsList {
    private Map<String, ExecuteCommand> commands = new HashMap<>();

    public void add(String name, ExecuteCommand executeCommand) {
        if (name != null)
            commands.put(name, executeCommand);
    }

    public String runCommand(Command command, ClientUtil clientState) {
        ExecuteCommand executable = commands.get(command.getName());
        if (executable != null)
            return executable.executeCommand(command.getArgs(), clientState);
        return "Command is invalid";
    }
}
