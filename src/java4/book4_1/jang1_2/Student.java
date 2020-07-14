package java4.book4_1.jang1_2;

public class Student extends Person {
    private  int id;
    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        // Person p = new Person(); 할당안됨.
        Person p = new Student("fred" , 1729); // 구체적인 서브클래스이므로 할당이가능
    }
}

