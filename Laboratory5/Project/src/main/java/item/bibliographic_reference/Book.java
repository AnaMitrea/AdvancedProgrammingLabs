package item.bibliographic_reference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import item.Item;

public class Book extends Item {
    private String publishingHouse;

    @JsonCreator
    public Book(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("location") String location,
            @JsonProperty("year") String year,
            @JsonProperty("author") String author,
            @JsonProperty("publishingHouse") String publishingHouse) {
        super(id,title,location,year,author);
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "\nBook(" +
                "publishingHouse:'" + publishingHouse + '\'' +
                ", id:'" + id + '\'' +
                ", title:'" + title + '\'' +
                ", location:'" + location + '\'' +
                ", year:'" + year + '\'' +
                ", author:'" + author + '\'' +
                ")\n";
    }
}
