package java3.exam15;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Employee {

    private String name;
    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }


}
