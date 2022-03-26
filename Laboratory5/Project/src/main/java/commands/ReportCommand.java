package commands;

import catalog.Catalog;
import exceptions.CustomException;
import freemarker.template.*;
import item.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends Command{
    public ReportCommand(Catalog catalog) {
        this.name = "Report";
        this.description = "creates and opens an HTML report representing the content of the catalog.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    /**
     * Method used for generating an HTML report using Apache FreeMarker dependency
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

            try(StringWriter out = new StringWriter()) {
                template.process(templateInfo, out);
                try {
                    FileWriter file = new FileWriter("target/templates/raportCatalog.html");

                    file.write(out.getBuffer().toString());
                    file.close();
                }catch(Exception e) {
                    throw new CustomException("Error: Cannot write to html file",e);
                }
                out.flush();
            }catch(Exception e) {
                throw new CustomException("Error: Cannot write to template",e);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Successfully created the HTML report.");
    }

}