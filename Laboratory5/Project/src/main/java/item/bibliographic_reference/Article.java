package item.bibliographic_reference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import item.Item;

public class Article extends Item {
    private String journalTitle;

    @JsonCreator
    public Article(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("location") String location,
            @JsonProperty("year") String year,
            @JsonProperty("author") String author,
            @JsonProperty("journalTitle") String journalTitle) {
        super(id,title,location,year,author);
        this.journalTitle = journalTitle;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    @Override
    public String toString() {
        return "\nArticle(" +
                "journalTitle:'" + journalTitle + '\'' +
                ", id:'" + id + '\'' +
                ", title:'" + title + '\'' +
                ", location:'" + location + '\'' +
                ", year:'" + year + '\'' +
                ", author:'" + author + '\'' +
                ")\n";
    }
}
