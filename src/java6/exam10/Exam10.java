package java6.exam10;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Exam10 {
    public static <E extends Comparable> E min(ArrayList<? extends Comparable> a) {

        E minE = null;

        if (a == null || a.size() == 0) {
            return null;
        }

        for (Comparable com : a) {
            if (minE == null || minE.compareTo(com) >= 0) {
                minE = (E) com;
            }
        }

        return minE;
    }

    public static <E extends Comparable> E max(ArrayList<? extends Comparable> a) {

        E maxE = null;

        if (a == null || a.size() == 0) {
            return null;
        }

        for (Comparable com : a) {
            if (maxE == null || maxE.compareTo(com) <= 0) {
                maxE = (E) com;
            }
        }

        return maxE;
    }
}
/*
    private <E extends Comparable> E minHelper(ArrayList<E> a) {

        E minE = null;
        for (int i = 0; i < a.size(); i++) {
            E e = a.get(i);
            if (minE.compareTo(e) <= 0) {
                minE = e;
            }
        }

        return minE;
 }*/

