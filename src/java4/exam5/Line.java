package java4.exam5;

import lombok.Getter;

@Getter
public class Line extends Shape {

    private Point to;

    public Line(Point from, Point to) {
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

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return new Line(getPoint(), to);
    }
}
