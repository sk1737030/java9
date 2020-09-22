package java6.exam2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exam2<E> {

    private E[] e;
    private int initSize = 1;
    private int peek;

    public Exam2() {
        e = (E[]) new Object[initSize];
        peek = -1;
    }

    public void put(E el) {
        if (peek >= initSize - 1) {
            e = Arrays.copyOf(e, e.length + initSize++);
        }
        e[++peek] = el;
    }

    public E getValue() {
        return e[peek];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E o = e[peek ];
        e[++peek] = null;

        return o;
    }

    public boolean isEmpty() {
        return peek < 0;
    }
}
