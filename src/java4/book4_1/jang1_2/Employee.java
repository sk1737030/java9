package java4.book4_1.jang1_2;

public class Employee implements Cloneable{
    private String name;
    private double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    public boolean workFor(Manager supervisor) {
        return true;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public final String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone(); // Object.clone의 반환 타입이 Object이므로 캐스트는 필수.
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee1 = new Employee("홍길동" , 1000);

        Employee employee2 = employee1.clone();

        System.out.println(employee2.getName());

        employee2.name = "test";
        System.out.println(employee1.getName());
        System.out.println(employee2.getName());
    }
}