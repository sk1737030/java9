package java6.exam7;

import java.util.Comparator;

public class Exam7<E> {

    private E key;
    private E key2;

    public Exam7(E key, E key2) {
        this.key = key;
        this.key2 = key2;
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
}
