package java4.exam5;

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

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return new Circle(getPoint(), getRadius());
    }
}
