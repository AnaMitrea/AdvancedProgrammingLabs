package utility;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import item.Item;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void saveCatalog(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), catalog);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveItem(Item item, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),item);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog loadCatalog(String path) throws IOException {
        Catalog catalog = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static Item loadItem(String path) throws IOException {
        Item item = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            item = objectMapper.readValue(new File(path), Item.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }
}
