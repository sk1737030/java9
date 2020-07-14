package java4.book4_1.jang3;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CustomArrayh {
    public static Object[] badCopyOf(Object[] array, int newLength) {
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < Math.min(array.length, newLength); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static Object goodCopyOf(Object array, int newLength) {
        Class<?> cl = array.getClass();
        if (!cl.isArray()) return null;
        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(array);
        Object newArray = Array.newInstance(componentType, newLength);
        for (int i = 0; i < Math.min(length, newLength); i++) {
            Array.set(newArray, i, Array.get(array, i));
        }
        return newArray;
    }

    public static void main(String[] args) {
        Object[] values = new Object[1000];

        for (int i = 0; i < values.length; i++) {
            Object value = new Integer(i);
            values[i] = Proxy.newProxyInstance( null, value.getClass().getInterfaces(), (Object proxy, Method m, Object[] margs) -> {
                System.out.println(value + "." + m.getName() + Arrays.toString(margs));
                return m.invoke(value, margs);
            });
        }

        Arrays.binarySearch(values, new Integer(500));
    }
}
