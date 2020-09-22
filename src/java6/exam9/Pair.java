package java6.exam9;

public class Pair<E extends Comparable<? super E>> {

    private E key;
    private E key2;

    public Pair(E key, E key2) {
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
        Pair exam8 = new Pair(1, 2);

        System.out.println(exam8.min());

    }
}
