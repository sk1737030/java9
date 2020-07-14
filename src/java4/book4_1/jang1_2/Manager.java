package java4.book4_1.jang1_2;


import lombok.Setter;

@Setter
public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }

    public boolean workFor(Manager supervisor) {
        return false;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    public Employee getSupervisor() {
        return null;
    }

    public String toString() {
        return getClass().getName() + "[name=" + getName() + ", salary=" +getSalary() +"]";
    }

    public static void main(String[] args) {
        Manager boss = new Manager("홍길동", 123000000);
        boss.setBonus(1000);

        boss.raiseSalary(1.2);

        Employee employee = boss;
        employee.getSalary();

        System.out.println(boss.toString());
        System.out.println("" + boss);
    }
}
