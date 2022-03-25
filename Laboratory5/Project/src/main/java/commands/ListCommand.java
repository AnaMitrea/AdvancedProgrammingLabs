package commands;

import catalog.Catalog;

public class ListCommand extends Command{
    public ListCommand() {
        this.name = "List";
        this.description = "prints the list of items on the screen.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    public void list(Catalog catalog) {
        System.out.println(catalog.getItems());
    }
}
