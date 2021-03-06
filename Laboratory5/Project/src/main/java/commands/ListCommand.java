package commands;

import catalog.Catalog;
import exceptions.CustomException;

public class ListCommand extends Command{
    public ListCommand() {
        this.name = "List";
        this.description = "prints the list of items on the screen.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    /**
     * Method used for listing the items of a catalog.
     * @param catalog   Catalog object
     */
    public void list(Catalog catalog) {
        try {
            if(catalog == null) {
                throw new CustomException("Cannot list a null catalog.");
            }
            if(catalog.getItems() == null) {
                throw new CustomException("Cannot list null items.");
            }
            System.out.println(catalog.getItems());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
