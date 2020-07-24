import java5.exam1.Exam1;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Chapter05Test {

    @Test
    public void exam01() {

        Exam1 exam1 = new Exam1();

        try {
/*
            ArrayList<Double> doubleArrayList = exam1.readValues("C:\\ch05\\double.txt");
            for (Double d : doubleArrayList) {
                System.out.println(d);
            }
*/

            Double d = exam1.sumOfValues("C:\\ch05\\double.txt");
            System.out.println(d);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e);
        }

    }

}
