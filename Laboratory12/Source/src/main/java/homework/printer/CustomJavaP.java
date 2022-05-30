package homework.printer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CustomJavaP {
    /**
     * A complete prototype, in the same manner as javap tool.
     * @param dynamicClass  Given Class to be parsed
     */
    public static void show(Class<?> dynamicClass) {
        System.out.println("Fields of class");
        Field[] classVars = dynamicClass.getDeclaredFields();
        for (Field classVar : classVars) {
            System.out.println(classVar);
        }

        System.out.println("\nConstructors of class");
        Constructor<?>[] cons = dynamicClass.getDeclaredConstructors();
        for (Constructor<?> constructor : cons) {
            System.out.println(constructor);
        }

        System.out.println("\nMethods of class");
        Method[] methods = dynamicClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
