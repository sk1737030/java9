import java4.exam1.Labeledpoint;
import java4.exam1.Point;
import org.junit.Assert;
import org.junit.Test;

public class Chapter04Test {

    @Test
    public void exam1() {
        Point point = new Point(12.5 , 10.5);
        Labeledpoint labeledpoint = new Labeledpoint("one", 30.5,50.5);
    }

    @Test
    public void exam2() {
        java4.exam2.Point point = new java4.exam2.Point(12.5 , 10.5);
        java4.exam2.Labeledpoint labeledpoint = new java4.exam2.Labeledpoint("one", 30.5,50.5);

        Assert.assertEquals(true, point.equals(new java4.exam2.Point(12.5,10.5)));
        Assert.assertEquals(false, point.equals(new java4.exam2.Point(88.5,11.5)));

        Assert.assertEquals(true, point.hashCode() == new java4.exam2.Point(12.5,10.5).hashCode());
        Assert.assertEquals(false, point.hashCode() == new java4.exam2.Point(166.5,110.5).hashCode());

        Assert.assertEquals(true, labeledpoint.equals(new java4.exam2.Labeledpoint ("one",30.5,50.5)));
        Assert.assertEquals(false, labeledpoint.equals(new java4.exam2.Labeledpoint ("two",88.5,11.5)));

        Assert.assertEquals(true, labeledpoint.hashCode() == new java4.exam2.Labeledpoint ("one",30.5,50.5).hashCode());
        Assert.assertEquals(false, labeledpoint.hashCode() == new java4.exam2.Labeledpoint ("two",88.5,11.5).hashCode());

        System.out.println(point.toString());
        System.out.println(labeledpoint.toString());
    }
}
