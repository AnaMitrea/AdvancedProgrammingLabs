package bonus.util;

import bonus.annotations.Test;
import com.github.javafaker.Faker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class LoadAndExecute {
    private final String path;
    private final String qualifiedName;

    public LoadAndExecute(String path, String qualifiedName) {
        this.path = path;
        this.qualifiedName = qualifiedName;
    }

    /**
     * Load a class in order to use it with the Class Loader
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
     * Executes the loaded class
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public void execute() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class myClass = load();
        Faker faker = new Faker();
        Object instance = myClass.getConstructor().newInstance();

        int invoked = 0;
        int annotatedMethodsFound = 0;
        int publicAnnotated = 0;

        Method[] allMethods = myClass.getDeclaredMethods();

        for (Method m : allMethods) {
            if (m.isAnnotationPresent(Test.class)) {
                annotatedMethodsFound++;

                if (Modifier.isPublic(m.getModifiers()) || Modifier.isStatic(m.getModifiers())) {
                    int parameterCount = m.getParameterCount();

                    publicAnnotated++;

                    try {
                        if (parameterCount == 0) {
                            m.invoke(instance);
                        } else {
                            List<Object> params = new LinkedList<>();

                            for (Class<?> parameter : m.getParameterTypes()) {
                                if (parameter.getTypeName().equals("int")) {
                                    params.add(faker.random().nextInt(1, 100));
                                } else if (parameter.getTypeName().equals("java.lang.String")) {
                                    params.add(faker.name().firstName());
                                } else
                                    params.add(null);
                            }

                            m.invoke(instance, params.toArray());
                        }
                        invoked++;
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(annotatedMethodsFound + " annotated methods found");
        System.out.println(publicAnnotated + " public annotated");
        System.out.println(invoked + " methods called");
        System.out.println(publicAnnotated - invoked + " failed on call");
    }

    public String getPath() {
        return path;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }
}
