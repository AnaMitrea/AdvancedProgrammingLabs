package solution;

import catalog.*;
import commands.*;
import item.Item;
import item.bibliographic_reference.*;

public class Homework {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("Books & Articles");
        Item book = new Book("knuth67","The Art of Computer Programming","d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "PublishingHouse1");
        Item article = new Article("java17","The Java Language Specification","https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others", "JournalTitle1");

        AddCommand addCommand = new AddCommand();
        addCommand.describeCommand();
        addCommand.add(catalog,book);
        addCommand.add(catalog,article);

        ListCommand listCommand = new ListCommand();
        listCommand.describeCommand();
        listCommand.list(catalog);

        ViewCommand viewCommand = new ViewCommand();
        viewCommand.view("catalog.json");
    }
}
