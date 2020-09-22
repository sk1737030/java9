package java6.exam8;

import org.w3c.dom.ls.LSOutput;

public class Exam8<E extends Comparable<? super E>> {

    private E key;
    private E key2;

    public Exam8(E key, E key2) {
        this.key = key;
        this.key2 = key2;
    }

    public E min() {
        return key.compareTo(key2) <= 0 ? key : key2;
    }

    public E max() {
        return key.compareTo(key2) > 0 ? key : key2;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public E getKey2() {
        return key2;
    }

    public void setKey2(E key2) {
        this.key2 = key2;
    }

    public static void main(String[] args) {
        Exam8 exam8 = new Exam8(1, 2);

        System.out.println(exam8.min());

    }
}
