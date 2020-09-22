package java6.exam2;

import java.util.Arrays;

public class Exam2_2<E> {

    private Object[] e;
    private int peek;

    public Exam2_2() {
        e = new Object[1];
        peek = -1;
    }

    public void put(E el) {
        if (peek == e.length) {
            e = Arrays.copyOf(e, e.length + 1);
        }
        e[++peek] = el;
    }

    public E getValue() {
        return (E) e[peek];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        Object o = e[peek ];
        if(o instanceof String) {
            System.out.println("sdfosd");
        }

        e[++peek] = null;

        return (E) o;
    }

    public boolean isEmpty() {
        return peek < 0;
    }
}
