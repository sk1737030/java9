package java4.exam5;

import lombok.Getter;

import java.util.Objects;

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

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return new Rectangle(getTopLeft(), getWidth(), getHeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
