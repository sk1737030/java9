package java5.exam12;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial {

    public static void test(int a) {
        assert a >= 0;
        System.out.println(a);
    }

    public static ArrayList<Exception> ex = new ArrayList<>();

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {//0! 일 경우


            return BigInteger.ONE;
        } else
            try {
                throw new Exception();
            } catch (Exception e) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                e.printStackTrace(new PrintWriter(out));
                ex.add(e);
            }

        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
