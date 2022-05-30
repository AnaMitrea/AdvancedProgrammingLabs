package compulsory;

import compulsory.util.LoadAndExecute;

public class MainCompulsory {
    public static void main(String[] args) {
        try{
            String path = "C:\\Users\\Ana\\Documents\\GitHub\\PA\\Laboratorul12\\Source\\target\\classes";
            String qualifiedName = "compulsory.tests.Test1";

            LoadAndExecute loadAndExecute = new LoadAndExecute(path,qualifiedName);
            loadAndExecute.execute();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
