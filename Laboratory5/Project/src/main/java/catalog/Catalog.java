package catalog;

import exceptions.CustomException;
import item.Item;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    public String name;
    public List<Item> items;

    public Catalog(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Catalog(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public Catalog() {
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        try {
            if(name == null) {
                throw new CustomException("Cannot assign a null name to the object.");
            }
            this.name = name;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item){
        try {
            if(item == null) {
                throw new CustomException("Cannot add a null item in the catalog.");
            }
            items.add(item);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method used for finding an item by giving an id.
     * @param id    The id to be searched.
     * @return      The item which has the specified id.
     */
    public Item findById(String id) {
        return items.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog(" + name +  " : " + items + ")\n";
    }
}
