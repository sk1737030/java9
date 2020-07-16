package java4.exam8;

public class ClassToString {


    public static void toString(Class<?> tClass) {
        System.out.println("getName() " + tClass.getName());
        System.out.println("getCanonicalName()" + tClass.getCanonicalName());
        System.out.println("getTypeName" + tClass.getTypeName());
        System.out.println("toGenericString" + tClass.toGenericString());
        System.out.println("toString()" + tClass.toString());
    }

    public class InnerClass {

    }
}
