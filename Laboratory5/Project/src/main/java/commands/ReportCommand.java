package commands;

import catalog.Catalog;
import exceptions.CustomException;
import freemarker.template.*;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

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
     * Method used for generating an HTML report using Apache FreeMarker dependency.
     */
    public void report(Catalog catalog){
        System.out.print("\nCreating HTML Report...");
        try{
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setDirectoryForTemplateLoading(new File("target/templates"));

            Template template = cfg.getTemplate("templateFile.ftl");
            Map<String,Object> templateInfo = new HashMap<>();
            templateInfo.put("catalog_name",catalog.getName());
            templateInfo.put("items",catalog.getItems());

            StringWriter out = new StringWriter();
            template.process(templateInfo, out);
            FileWriter file = new FileWriter("target/templates/raportCatalog.html");

            file.write(out.getBuffer().toString());
            file.close();
            out.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Successfully created the HTML report.");

        ViewCommand viewCommand = new ViewCommand();
        viewCommand.view("target/templates/raportCatalog.html");
    }
}