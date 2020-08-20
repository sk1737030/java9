package java6.book.book62.exam1;

public class Exam1<K> {

    private K[] k;
    private int peek;

    public Exam1(K[] k, int peek) {
        this.k = k;
        this.peek = 0;
    }

    public void push(K value) {
        k[peek++] = value;
    }

    public K pop() {
        return k[peek--];
    }

    public boolean isEmpty() {
        return peek == 0;
    }
}
