public class Compulsory {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("Books&Articles");
        Item book = new Book("knuth67","The Art of Computer Programming","d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "PublishingHouse1");
        Item article = new Article("java17","The Java Language Specification","https://docs.oracle.com/javase/specs/jls/se17/html/index.html","2021", "James Gosling & others", "JournalTitle1");

        catalog.add(book);
        catalog.add(article);

        System.out.println(catalog);
    }
}
