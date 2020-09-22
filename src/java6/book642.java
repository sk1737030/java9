package java6;

import java.util.ArrayList;

public class book642 {
    public static void main(String[] args) {

    }

    public static <T> void printAll(T[] elements, Predicate<T> filter) {
        for (T e : elements)
            if(filter.test(e))
                System.out.println(e.toString());
    }

    public static void swap(ArrayList<?> elements, int i, int j){
        swapHelper(elements,i,j);

    }

    private static <T> void swapHelper(ArrayList<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
