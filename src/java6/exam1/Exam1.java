package java6.exam1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exam1<K> {

    private List<K> k;
    private int peek;

    public Exam1() {
        k = new ArrayList<K>();
        this.peek = 0;
    }

    public K getStackValue() {
        return k.get(peek-1);
    }

    public void put(K value) {
        k.add(value);
        peek++;
    }

    public Object pop() {
        if (isEmpty())
            return null;
        return k.remove(--peek);
    }

    public boolean isEmpty() {
        return peek == 0;
    }

    @Override
    public String toString() {
        return "Exam1{" +
                "k=" + k.toString() +
                ", peek=" + peek +
                '}';
    }
}

