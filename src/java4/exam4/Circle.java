package java4.exam4;

import java4.exam4.Point;
import lombok.Getter;

@Getter
public class Circle extends Shape {
    double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
    }

    @Override
    public Point getCenter() {
        return getPoint();
    }
}
