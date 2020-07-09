import java3.exam1.Employee;
import java3.exam1.Measurable;
import java3.exam4.IntSequence;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class Chapter03Test {

    @Test
    public void ex01() {

        Measurable[] emp = new Measurable[5];

        for (int i = 0; i < 5; i++) {
            emp[i] = new Employee(1000 * i);
        }

        Assert.assertTrue(Measurable.average(emp) == 2000);
    }

    /**
     * 이름을 가져오는데 캐스트가 필요한이유는?
     * - Measuable에는 getName을 안가지고있어서.
     */
    @Test
    public void ex02() {

        Measurable[] emp = new Measurable[5];

        for (int i = 0; i < 5; i++) {
            emp[i] = new Employee("김" + i, 1000 * i);
        }

        Assert.assertTrue(Measurable.largeSt(emp).equals("김4"));
    }

    @Test
    public void ex04() {
        int[] numbers = {1, 2, 3, 1, 5, 6};
        int index = 0;

        IntSequence intSequence = IntSequence.of(numbers);

        while (intSequence.hasNext()) {
            Assert.assertEquals(numbers[index++], intSequence.next());
        }
    }

    @Test
    public void ex05() {
        IntSequence seq = IntSequence.constant(1);

        int i = 0;
        while (seq.hasNext()) {
            if (i > 10) {
                break;
            }
            System.out.println(seq.next());
            i++;
        }
    }

    @Test
    public void ex0502() {
        IntSequence.constant(1, System.out::println);
    }

}
