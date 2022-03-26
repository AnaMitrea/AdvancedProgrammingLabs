package solution;

import catalog.*;
import commands.*;
import exceptions.CustomException;
import item.Item;
import item.bibliographic_reference.*;
import utility.CatalogUtil;

public class Homework {
    public static void addItemsIntoCatalog(Catalog catalog) throws CustomException {
        Item book1 = new Book("knuth67","The Art of Computer Programming","d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "PublishingHouse1");
        Item article = new Article("java17","The Java Language Specification","https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others", "JournalTitle1");
        Item book2 = new Book("lordrings1","The Lord of the Rings","d:/books/fantasy/tlor.ps","1955","J.R.R Tolkien","Allen & Unwin");

        AddCommand addCommand = new AddCommand();
        addCommand.describeCommand();
        addCommand.add(catalog,book1);
        addCommand.add(catalog,article);
        addCommand.add(catalog,book2);
        // Exception:
        // addCommand.add(catalog,null);
    }

    public static void listItemsFromCatalog(Catalog catalog) {
        ListCommand listCommand = new ListCommand();
        listCommand.describeCommand();
        listCommand.list(catalog);
    }

    public static void viewItemsFromCatalog(String path) {
        ViewCommand viewCommand = new ViewCommand();
        viewCommand.describeCommand();
        viewCommand.view(path);
    }

    public static void reportCatalog(Catalog catalog) {
        ReportCommand reportCommand = new ReportCommand();
        reportCommand.describeCommand();
        reportCommand.report(catalog);
    }

    public static void main(String[] args) throws CustomException {
        Catalog catalog = new Catalog("My Catalog");
        addItemsIntoCatalog(catalog);

        CatalogUtil.saveCatalog(catalog,"target/json-files/catalog.json");

        listItemsFromCatalog(catalog);
        viewItemsFromCatalog("target/json-files/catalog.json");
        reportCatalog(catalog);
    }
}
