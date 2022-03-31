package commands;

import java.io.*;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

public class InfoCommand extends Command{
    public InfoCommand() {
        this.name = "Info";
        this.description = "extracts metadata from catalog items in order to display them.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    /**
     * Method used for getting the metadata and the contents of a html file using Apache Tika.
     */
    public void info() {
        System.out.println("Getting the metadata of the HTML report...");
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try {
            FileInputStream inputStream = new FileInputStream("target/templates/raportCatalog.html");
            ParseContext pContext = new ParseContext();

            HtmlParser htmlparser = new HtmlParser();
            htmlparser.parse(inputStream, handler, metadata,pContext);
            System.out.println("\nContents of the html report:" + handler);
            System.out.println("Metadata of the html file:");
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                System.out.println(name + ": " + metadata.get(name));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
