package java6.exam5;

public class Exam5 {

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static <T extends Double> T[] swap2(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static void main(String[] args) {
        Object[] result = Exam5.swap(0, 1, 1.5, 2, 3);
        System.out.println(result);

        Double[] result2 = Exam5.<Double>swap2(0, 1, 1.5, 2D, 3D);
        System.out.println(result2);
    }
}
