package java4.exam2;

import java4.exam2.Point;

import java.util.Objects;


public class Labeledpoint extends Point {
    private String label;

    public Labeledpoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

    public boolean equals(Object other) {
        if (!super.equals(other)) {
            return false;
        }
        return this.label.equals(((Labeledpoint) other).getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }

    @Override
    public String toString() {
        return super.toString() + "label='" + label + '\'' + '}';
    }


}
