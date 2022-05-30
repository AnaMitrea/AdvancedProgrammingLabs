package command;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Command {
    private String name;
    private List<String> args = new LinkedList<>();

    public Command(String command) {
        String[] words = command.split(" ");
        name = words[0];
        args.addAll(Arrays.asList(words).subList(1, words.length));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}

