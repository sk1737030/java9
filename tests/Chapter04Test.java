import java4.exam1.Labeledpoint;
import java4.exam1.Point;
import java4.exam4.Rectangle;
import java4.exam6.DisCountedItem;
import java4.exam6.Item;
import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(true, point.equals(new java4.exam2.Point(12.5, 10.5)));
        Assert.assertEquals(false, point.equals(new java4.exam2.Point(88.5, 11.5)));

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


}
