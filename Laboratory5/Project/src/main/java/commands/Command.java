package commands;

public abstract class Command {
    protected String name;
    protected String description;

    public abstract void describeCommand();
}
