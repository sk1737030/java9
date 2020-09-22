import java6.exam1.Exam1;
import java6.exam2.Exam2;
import java6.exam3.Exam3;
import java6.exam6.Exam6;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Chapter06Test {

    @Test
    public void ex01() {
        // given
        Exam1<Integer> customStack = new Exam1<>();

        // when
        customStack.put(1);

        // that
        assertEquals((int) customStack.getStackValue(), 1);

        // that
        assertEquals(customStack.pop(), 1);

        // that
        assertTrue(customStack.isEmpty());
    }

    // Exam2_2와 동일
    @Test
    public void ex02() {
        // given
        Exam2<Integer> customStack2 = new Exam2<>();

        // when
        customStack2.put(1);

        // that
        assertEquals((int) customStack2.getValue(), 1);
        // when
        customStack2.put(2);

        // when
        customStack2.put(3);

        // that
        assertEquals((int) customStack2.pop(), 3);
    }

    @Test
    public void ex03() {
        // given
        Exam3<String, String> exam3 = new Exam3<>();

        // when
        exam3.put("A", "AAA");

        // that
        assertEquals(exam3.getEntry("A").getValue(), "AAA");
        assertEquals(exam3.remove("A").getValue(), "AAA");
    }

    @Test
    public void ex06() {
        // given
        List<Integer> add1 = new ArrayList<>();
        add1.add(1);
        add1.add(2);

        List<Integer> add2 = new ArrayList<>();
        add2.add(3);

        // when
        List<Integer> result = Exam6.addAll(add1, add2);

        // then
        assertArrayEquals(result.toArray(),Arrays.asList(1,2,3).toArray());

    }

}
