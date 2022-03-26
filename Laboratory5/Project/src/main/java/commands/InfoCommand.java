package commands;

import java.io.*;

import exceptions.CustomException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class InfoCommand extends Command{
    public InfoCommand() {
        this.name = "Info";
        this.description = "extracts metadata from catalog items in order to display them.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    public void info() throws IOException, TikaException, SAXException, CustomException {
        System.out.println("Getting the metadata of the HTML report...");
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try {
            FileInputStream inputStream = new FileInputStream(new File("target/templates/raportCatalog.html"));
            ParseContext pContext = new ParseContext();

            //Html parser
            HtmlParser htmlparser = new HtmlParser();
            htmlparser.parse(inputStream, handler, metadata,pContext);
            System.out.println("\nContents of the document:" + handler.toString());
            System.out.println("Metadata of the document:");
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                System.out.println(name + ":   " + metadata.get(name));
            }
        }catch(Exception e) {
            throw new CustomException("Error: Cannot show information of the HTML report.", e);
        }
    }
}
