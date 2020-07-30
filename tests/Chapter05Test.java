import java5.Factorial;
import java5.exam09.Exam09;
import java5.exam13.MinValues;
import java5.exam1toexam3.Exam1;
import java5.exam4.Exam4;
import java5.exam4.ReturnErrorCode;
import java5.exam5.Exam5;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void exam04() {

        Exam4 exam1 = new Exam4();
        ReturnErrorCode re = null;
        try {
            re = exam1.readValues("C:\\ch05\\double.txt");
        } catch (Exception e) {
            assertEquals(500, re.getCode());
        }

        ReturnErrorCode re2 = exam1.sumOfValues("C:\\ch05\\double.txt");

        assertEquals(500, re2.getCode());
    }

    @Test
    public void exam05() {
        Exam5 exam5 = new Exam5();

        try {
            exam5.copy("C:\\ch05\\double.t333xt", "test");
        } catch (Exception e) {
            System.out.println("ComeHere");
            e.printStackTrace();
        }

    }

    @Test
    public void exam06a() {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void exam06b() {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exam06c() {

        try (BufferedReader in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8)) {
            // in

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exam09() {
        Exam09 exam09 = new Exam09();
        exam09.readWithAutoClose("C:\\ch05\\double.txt");
    }

    @Test
    public void exam11() {
        assertEquals(Factorial.factorial(BigInteger.valueOf(10)).intValue(), 3628800);
        Factorial.ex.forEach(System.out::println);
    }

    @Test
    public void exam13() {

        long startTime = System.nanoTime();
        MinValues minValues = new MinValues();

        assertEquals(1, minValues.min(1, 2, 3, 4, 5));
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;

        System.out.println(estimatedTime);
    }


}
