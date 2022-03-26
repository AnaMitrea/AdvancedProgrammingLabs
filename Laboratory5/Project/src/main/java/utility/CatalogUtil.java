package utility;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CustomException;
import item.Item;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    /**
     * Saves a Catalog object into a .json file.
     * @param catalog               Catalog object to be saved
     * @param path                  File path
     * @throws CustomException      Custom Exception to be thrown in case of an error
     */
    public static void saveCatalog(Catalog catalog, String path) throws CustomException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(catalog == null) {
                throw new CustomException("Error: Cannot save catalog.");
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), catalog);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves a Item object into a .json file.
     * @param item                  Item object to be saved
     * @param path                  File path
     * @throws CustomException      Custom Exception to be thrown in case of an error
     */
    public static void saveItem(Item item, String path) throws CustomException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(item == null) {
                throw new CustomException("Error: Cannot save item.");
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),item);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads data from an external file into a Catalog object
     * @param path              File path
     * @return                  The loaded object
     */
    public static Catalog loadCatalog(String path) {
        Catalog catalog = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return catalog;
    }

    /**
     * Loads data from an external file into an Item object
     * @param path              File path
     * @return                  The loaded object
     */
    public static Item loadItem(String path){
        Item item = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            item = objectMapper.readValue(new File(path), Item.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }
}
