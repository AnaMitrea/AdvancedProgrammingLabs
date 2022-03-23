package catalog.util;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),catalog);
    }

    public static Catalog load(String path) throws IOException {
        Catalog catalog = null;
        ObjectMapper objectMapper = new ObjectMapper();
        catalog = objectMapper.readValue(new File(path), Catalog.class);

        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
