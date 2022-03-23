package catalog.item.bibliographic_reference;

import catalog.item.Item;

public class Book extends Item {
    private String publishingHouse;

    public Book(String id, String title, String location, String year, String author, String publishingHouse) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
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
        return "\nitem.bibliographic_reference.Book(" +
                "publishingHouse:'" + publishingHouse + '\'' +
                ", id:'" + id + '\'' +
                ", title:'" + title + '\'' +
                ", location:'" + location + '\'' +
                ", year:'" + year + '\'' +
                ", author:'" + author + '\'' +
                ")\n";
    }
}
