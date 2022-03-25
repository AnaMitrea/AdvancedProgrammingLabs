package solution;

import catalog.*;
import commands.*;
import item.Item;
import item.bibliographic_reference.*;
import utility.CatalogUtil;

import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("My Catalog");
        Item book = new Book("knuth67","The Art of Computer Programming","d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "PublishingHouse1");
        Item article = new Article("java17","The Java Language Specification","https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others", "JournalTitle1");

        AddCommand addCommand = new AddCommand();
        addCommand.describeCommand();
        addCommand.add(catalog,book);
        addCommand.add(catalog,article);

        CatalogUtil.saveCatalog(catalog,"target/catalog.json");

        ListCommand listCommand = new ListCommand();
        listCommand.describeCommand();
        listCommand.list(catalog);

        ViewCommand viewCommand = new ViewCommand();
        viewCommand.describeCommand();
        viewCommand.view("catalog.json");

        ReportCommand reportCommand = new ReportCommand();
        reportCommand.describeCommand();
        reportCommand.report(catalog);
    }
}
