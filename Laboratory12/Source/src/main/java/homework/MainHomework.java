package homework;

import homework.util.LoadAndExecute;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class MainHomework {
    private static List<String> getClassNamesInFolder(String folderName) {
        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles();

        List<String> classes = new LinkedList<>();

        if (listOfFiles != null)
            for (File file : listOfFiles)
                if (file.isFile() && file.getName().endsWith(".class"))
                    classes.add(file.getName());

        return classes;
    }


    private static List<String> getClassesNamesInJar(String pathToJar) {
        List<String> classes = new ArrayList<>();

        try {
            JarInputStream jarFile = new JarInputStream
                    (new FileInputStream(pathToJar));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                if (jarEntry.getName().endsWith(".class")) {
                    classes.add(jarEntry.getName().replaceAll("/", "\\."));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Ana\\Documents\\GitHub\\PA\\Laboratorul12\\Source\\target\\classes";

        try {
            // List<String> classNames = getClassesNamesInJar(pathJar);

            List<String> classNames = getClassNamesInFolder(path);

            for (String className : classNames) {
                LoadAndExecute loadAndExecute = new LoadAndExecute(path, className.substring(0, className.length() - 6));
                loadAndExecute.execute();
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
