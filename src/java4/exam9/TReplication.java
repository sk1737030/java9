package java4.exam9;

import java4.exam6.Item;

import java.lang.reflect.Field;

public class TReplication {
    public static <T> void toString(T t) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();

        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(t);

            builder.append(field.getName()).append("  :  ").append(obj).append("\n");
        }

        System.out.println(builder);
    }
}
