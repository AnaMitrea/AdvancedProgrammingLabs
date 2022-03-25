package commands;

import java.awt.*;

import java.io.File;

public class ViewCommand extends Command{
    public ViewCommand(){
        this.name = "View";
        this.description = "opens an item using the native operating system application.";
    }

    @Override
    public void describeCommand() {
        System.out.println("The " + name + " command " + description);
    }

    public void view(String path){
        File file = new File("target/" + path);
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
       catch(Exception e) {
           System.out.println(e.getMessage());
       }

    }
}
