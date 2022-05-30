package compulsory.util;

import compulsory.annotations.Test;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class LoadAndExecute {
    private final String path;
    private final String qualifiedName;

    public LoadAndExecute(String path, String qualifiedName) {
        this.path = path;
        this.qualifiedName = qualifiedName;
    }

    /**
     * Class loader
     * @return
     */
    public Class load() {
        try {
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    new URL("file:///" + path)
            }, this.getClass().getClassLoader());

            return urlClassLoader.loadClass(qualifiedName);
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Class execute
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void execute() throws InstantiationException, IllegalAccessException {
        Class myClass = load();

        System.out.println("\nPackage: " + myClass.getPackage().getName());
        System.out.println("Methods: " + Arrays.toString(myClass.getMethods()));

        int invoked = 0;

        for (Method m : myClass.getMethods()) {
            if (m.isAnnotationPresent(Test.class) && m.getParameterCount() == 0) {
                try {
                    m.invoke(null);
                    invoked++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(invoked + " methods called");
    }

    public String getPath() {
        return path;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }
}
