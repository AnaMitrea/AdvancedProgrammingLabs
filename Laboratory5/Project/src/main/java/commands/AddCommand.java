package commands;

import catalog.Catalog;
import exceptions.CustomException;
import item.Item;

public class AddCommand extends Command{
    public AddCommand() {
        this.name = "Add";
        this.description = "adds a new entry (such as Articles, Books or other bibliographic references) into a catalog.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    /**
     * Adds an item in a specified catalog only if the item is not null.
     * @param catalog               Catalog object
     * @param item                  Item to be addes
     * @throws CustomException      Custom Exception
     */
    public void add(Catalog catalog, Item item) throws CustomException {
        if(item == null) {
            throw new CustomException("Cannot add a null item in the catalog.");
        }
        catalog.getItems().add(item);
    }
}
