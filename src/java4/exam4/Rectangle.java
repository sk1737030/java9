package java4.exam4;

import java4.exam4.Point;
import lombok.Getter;

@Getter
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }


    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
    }

    @Override
    public Point getCenter() {
        Point point = getTopLeft();
        point.setX(point.getX() + (width / 2));
        point.setY(point.getY() + (height / 2));
        return point;
    }

    public Point getTopLeft() {
        return getPoint();
    }

}
