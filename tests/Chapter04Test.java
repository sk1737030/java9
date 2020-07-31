import java3.exam8.Exam8;
import java4.exam1.Labeledpoint;
import java4.exam1.Point;
import java4.exam10.MethodPrinter;
import java4.exam4.Rectangle;
import java4.exam6.DisCountedItem;
import java4.exam6.Item;
import java4.exam7.Color;
import java4.exam8.ClassToString;
import java4.exam9.TReplication;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Optional;

public class Chapter04Test {

    @Test
    public void exam1() {
        Point point = new Point(12.5, 10.5);
        Labeledpoint labeledpoint = new Labeledpoint("one", 30.5, 50.5);
    }

    @Test
    public void exam2() {
        java4.exam2.Point point = new java4.exam2.Point(12.5, 10.5);
        java4.exam2.Labeledpoint labeledpoint = new java4.exam2.Labeledpoint("one", 30.5, 50.5);

        Assert.assertEquals(point, new java4.exam2.Point(12.5, 10.5));
        Assert.assertNotEquals(point, new java4.exam2.Point(88.5, 11.5));

        Assert.assertEquals(point.hashCode(), new java4.exam2.Point(12.5, 10.5).hashCode());
        Assert.assertNotEquals(point.hashCode(), new java4.exam2.Point(166.5, 110.5).hashCode());

        Assert.assertTrue(labeledpoint.equals(new java4.exam2.Labeledpoint("one", 30.5, 50.5)));
        Assert.assertFalse(labeledpoint.equals(new java4.exam2.Labeledpoint("two", 88.5, 11.5)));

        Assert.assertEquals(true, labeledpoint.hashCode() == new java4.exam2.Labeledpoint("one", 30.5, 50.5).hashCode());
        Assert.assertEquals(false, labeledpoint.hashCode() == new java4.exam2.Labeledpoint("two", 88.5, 11.5).hashCode());

        System.out.println(point.toString());
        System.out.println(labeledpoint.toString());
    }

    @Test
    public void exam4() {
        java4.exam4.Point point = new java4.exam4.Point(10.5, 100.5);

        Rectangle rectangle = new Rectangle(point, 10, 10);
        Assert.assertEquals((new java4.exam4.Point(15.5, 105.5)).hashCode(), rectangle.getCenter().hashCode());
    }

    @Test
    public void exam5() throws CloneNotSupportedException {
        java4.exam5.Point point = new java4.exam5.Point(10.5, 100.5);

        java4.exam5.Rectangle rectangle = new java4.exam5.Rectangle(point, 10, 10);
        java4.exam5.Rectangle clonedRec = rectangle.clone();
        Assert.assertEquals(clonedRec.hashCode(), rectangle.hashCode());
    }

    @Test
    public void exam6() {
        Item y = new Item("one", 1200);

        DisCountedItem x = new DisCountedItem("one", 1200, 1000);

        DisCountedItem z = new DisCountedItem("one", 1200, 1100);

        Assert.assertEquals(x, y);
        Assert.assertEquals(y, z);
        Assert.assertNotEquals(z, x);
    }

    @Test
    public void exam7() {
        Color color = Color.BLUE;

        Assert.assertEquals("BLUE", color.name());
    }

    @Test
    public void exam8() {
        System.out.println("---- 참조타입 ---- ");
        String a = "8";
        ClassToString.toString(a.getClass());

        System.out.println("--- 기본 타입----");
        ClassToString.toString(char.class.getClass());

        System.out.println("---- 스트링 배열 ---- ");
        String[] c = {"String", "ABC"};
        ClassToString.toString(c.getClass());

        System.out.println("---- 이너 클래스 ---- ");
        ClassToString.toString(ClassToString.InnerClass.class);

        System.out.println("---- 제너릭타입  ----- ");
        ClassToString.toString(Optional.class);
    }

    @Test
    public void exam9() throws IllegalAccessException {
        Item item = new Item("Item", 1000);
        TReplication.toString(item);
    }

    @Test
    public void exam10() throws ClassNotFoundException, IllegalAccessException {
        MethodPrinter methodPrinter = new MethodPrinter();
        methodPrinter.methodPrinter("java.lang.Integer");

    }

    @Test
    public void exam11() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> claszz = Class.forName("java.lang.System");

        Field field = claszz.getField("out");
        Object out = field.get(null);
        System.out.println(out.getClass());
        Class<?> classzz = Class.forName(field.getType().getName());

        Method method = classzz.getMethod("println", String.class);

        method.invoke(out, "method invoke Test()");
    }


    @Test
    public void exam12() throws Exception {
        java4.exam5.Point point = new java4.exam5.Point(12, 11);
        java4.exam5.Point point2 = new java4.exam5.Point(12, 11);
        long first = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            point.equals(point2);
        }
        long second = System.currentTimeMillis();
        System.out.println(second - first);


        first = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Class<?> classzz = Class.forName("java4.exam5.Point");
            Method method = classzz.getMethod("equals", Object.class);
            method.invoke(point, point2);
        }
        second = System.currentTimeMillis();
        System.out.println(second - first);
    }

    @Test
    public void exam13() throws Exception {
        System.out.println("test");

        Class<?> claszz = Class.forName("java.lang.Sysztem");

        Field field = claszz.getField("out");
        Object out = field.get(null);
        System.out.println(out.getClass());
        Class<?> classzz = Class.forName(field.getType().getName());

        Method method = classzz.getMethod("println", String.class);

        method.invoke(out, "method invoke Test()");
    }
}
