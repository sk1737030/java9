package java4.exam10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodPrinter {
    public void methodPrinter(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);

        while (!cl.getName().equals(Object.class.getName())) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName() +
                        Arrays.toString(m.getParameters())
                );
            }
            cl = cl.getSuperclass();
        }

    }
}
