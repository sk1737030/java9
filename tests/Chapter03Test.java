import java3.exam1.Employee;
import java3.exam1.Measurable;

import java3.exam10.Exam10;
import java3.exam11.Exam11;
import java3.exam12.Exam12;
import java3.exam13.Exam13;
import java3.exam14.Exam14;
import java3.exam8.Exam8;
import java3.exam9.Gretter;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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

        java3.exam4.IntSequence intSequence = java3.exam4.IntSequence.of(numbers);

        while (intSequence.hasNext()) {
            Assert.assertEquals(numbers[index++], intSequence.next());
        }
    }

    @Test
    public void ex05() {
        java3.exam4.IntSequence seq = java3.exam4.IntSequence.constant(1);

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
        java3.exam5.IntSequence seq = java3.exam5.IntSequence.constant(1, System.out::println);

        int i = 0;
        while (seq.hasNext()) {
            if (i > 10) {
                break;
            }
            seq.next();
            i++;
        }
    }

    @Test
    public void ex08() {
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("A", "C", "B", "D"));

        Exam8.luckSort(strs, (String first, String second) -> first.compareTo(second));
    }

    /**
     * Runnable을 구현하는 Gretter 클래스를 작성하라. 이클래스의 run 메서드는 "Hello, " + target 을 n번 출력해야한다
     * 각기 다른 메세지로 인스턴스를 두 개 생성해 두 스레드에서 동시에 실행하라.
     */
    @Test
    public void ex09() {
        Runnable gretter = new Gretter(10, "World");
        Runnable gretter2 = new Gretter(10, "Java");

        Thread thread1 = new Thread(gretter);
        Thread thread2 = new Thread(gretter2);


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {

        }
    }

    /**
     * 첫 번째 메서드는 각 태스크를 별도의 스레드에서 실행한 후 반환해야한다..
     * 두 번째 메서드는 모든 태스크를 현재 스레드에서 실행하고 마지막 테스크가 완료될 때 반환해야한다.
     */
    @Test
    public void exam10() {
        Runnable r1 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("first" + i);
                } catch (InterruptedException e) {
                }
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("second" + i);
                } catch (InterruptedException e) {
                }
            }
        };

        Exam10.runTogether(r1, r2);
        //Exam10.runInOrder(r1,r2);
    }

    @Test
    public void ex11() {
        Exam11.getSubDirectory("C:\\Users\\dh");
    }

    @Test
    public void ex12() {
        Exam12.getSubFileName("C:\\Users\\dh", "sql");
    }

    @Test
    public void ex13() {
        Exam13.getSubDirectoryWithOrder("C:\\Users\\dh\\.p2");
    }

    @Test
    public void ex14() {
        Runnable run1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("run1");
            }
        };
        Runnable run2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("run2");
            }
        };

        Runnable runnable = Exam14.run(run1, run2);
        runnable.run();
    }

    @Test
    public void ex15() {
        List<java3.exam15.Employee> employees = new ArrayList<>();
        employees.add(new java3.exam15.Employee("A", 1000));
        employees.add(new java3.exam15.Employee("B", 2000));
        employees.add(new java3.exam15.Employee("C", 2000));
        employees.add(new java3.exam15.Employee("D", 1000));
        employees.add(new java3.exam15.Employee("E", 5000));

        java3.exam15.Employee[] employees1 = employees.toArray(new java3.exam15.Employee[employees.size()]);

        Arrays.sort(employees1, Comparator.comparing(java3.exam15.Employee::getSalary, (o1, o2) -> o1 - o2)
                .thenComparing(java3.exam15.Employee::getName, String::compareToIgnoreCase));
                                                                // 생성자참조 (o1, o2) -> o1.compareToIgnoreCase(o2) 와 같음

        Arrays.asList(employees1).forEach(employee -> System.out.println(employee.toString()));
        System.out.println("");

        Arrays.sort(employees1, Comparator.comparing(java3.exam15.Employee::getSalary, Comparator.reverseOrder())
                .thenComparing(java3.exam15.Employee::getName,Comparator.reverseOrder()));
        Arrays.asList(employees1).forEach(employee -> System.out.println(employee.toString()));
    }
}
