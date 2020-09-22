package java6.exam9;

import java.util.ArrayList;

public class Exam9 {
    public static <E extends Comparable<? super E>> Pair<E> firstLast(ArrayList<? extends Comparable> a) {
        if (a == null || a.size() == 0) {
            return null;
        }

        E first = (E) a.get(0);
        E last = (E) a.get(a.size() - 1);

        return new Pair<>(first,last);
    }
}
