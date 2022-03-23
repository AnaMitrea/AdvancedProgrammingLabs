package catalog.item;

public abstract class Item {
    protected String id;
    protected String title;
    protected String location;
    protected String year;
    protected String author;

    abstract public String toString();
    abstract public String getId();
    abstract public void setId(String id);
    abstract public String getTitle();
    abstract public void setTitle(String title);
    abstract public String getLocation();
    abstract public void setLocation(String location);
    abstract public String getYear();
    abstract public void setYear(String year);
    abstract public String getAuthor();
    abstract public void setAuthor(String author);
}
