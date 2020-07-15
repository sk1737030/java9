package java4.exam4;

import java4.exam4.Point;
import lombok.Getter;

@Getter
public class Line extends Shape{

    private Point to;

    public Line(java4.exam4.Point from, java4.exam4.Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        to.setX(to.getX() + dx);
        to.setY(to.getY() + dy);
    }

    public Point getFrom() {
        return getPoint();
    }

    @Override
    public Point getCenter() {
        return new Point( getTo().getX() - getFrom().getX(),  getTo().getY() - getFrom().getY());
    }
}
