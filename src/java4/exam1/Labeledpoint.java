package java4.exam1;

import lombok.Getter;

import java.util.Objects;


public class Labeledpoint extends Point {
    private String label;

    public Labeledpoint(String label, double x, double y) {
        super(x,y);
        this.label = label;
    }


    public String getLabel() {
        return label;
    }



}
