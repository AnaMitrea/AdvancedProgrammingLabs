package solution;

import catalog.*;
import item.*;
import item.bibliographic_reference.*;
import java.util.ArrayList;
import java.util.List;

public class Compulsory {
    public static void main(String[] args){
        Item book = new Book("knuth67","The Art of Computer Programming","d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "PublishingHouse1");
        List<Item> itemList = new ArrayList<>();
        itemList.add(book);

        Catalog catalog = new Catalog("Books & Articles", itemList);

        Item article = new Article("java17","The Java Language Specification","https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others", "JournalTitle1");
        catalog.add(article);
        CatalogUtil.saveCatalog(catalog,"target/catalog.json");

        Catalog newCatalog = CatalogUtil.loadCatalog("target/catalog.json");;
        System.out.println(newCatalog);
    }
}
