package java3.exam8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Exam8 {
    public static void luckSort(ArrayList<String> strings, Comparator<String> comp) {
        boolean perfect = true;

        while (true) {
            perfect = true;

            Collections.shuffle(strings);

            loop:
            for (int i = 0; i < strings.size(); i++) {

                for (int j = i + 1; j < strings.size(); j++) {
                    perfect = comp.compare(strings.get(i), strings.get(j)) < 0;

                    if (!perfect) {
                        break loop;
                    }
                }
            }

            if (perfect) {
                System.out.println(strings);
                break;
            }

        }
    }
}