package java3.exam1;

import lombok.Getter;

@Getter
public class Employee implements Measurable {

    private String name;
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }


}
