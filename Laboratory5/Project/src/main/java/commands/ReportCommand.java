package commands;

import catalog.Catalog;
import freemarker.template.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReportCommand extends Command{
    public ReportCommand() {
        this.name = "Report";
        this.description = "creates and opens an HTML report representing the content of the catalog.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    /**
     * Method used for generating an HTML report using Apache FreeMarker dependency
     * @param catalog       Catalog object
     */
    public void report(Catalog catalog){
        System.out.print("\nCreating HTML Report...");
        try{
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File("target/templates"));

            Template template = cfg.getTemplate("templateFile.ftlh");
            Writer out = new OutputStreamWriter(new FileOutputStream("target/templates/templateFile.html"));
            template.process(catalog, out);
            System.out.println(" Successfully created the report.");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}