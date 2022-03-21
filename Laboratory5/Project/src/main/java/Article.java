public class Article extends Item{
    private String journalTitle;

    public Article(String id, String title, String location, String year, String author, String journalTitle) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
        this.journalTitle = journalTitle;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getYear() {
        return this.year;
    }

    @Override
    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nArticle(" +
                "journalTitle:" + journalTitle +
                ", id:'" + id + '\'' +
                ", title:'" + title + '\'' +
                ", location:'" + location + '\'' +
                ", year:'" + year + '\'' +
                ", author:'" + author + '\'' +
                ")";
    }
}
