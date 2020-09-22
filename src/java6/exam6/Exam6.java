package java6.exam6;

import java.util.ArrayList;
import java.util.List;

public class Exam6 {

    public static <T> List<T> addAll(List<T> one, List<? extends T> two) {



        for (int i = 0; i < two.size(); i++) {
            one.add(two.get(i));
        }

        return one;
    }

    public static <T> List<Object> addAllSuper(List<Object> one, List<? super T> two) {
        one.addAll(two);

        return one;
    }
}

