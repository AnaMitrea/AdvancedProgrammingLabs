package commands;

import catalog.Catalog;

public class ReportCommand extends Command{
    public ReportCommand() {
        this.name = "Report";
        this.description = "creates and opens an HTML report representing the content of the catalog.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    public void report(Catalog catalog){

    }
}
