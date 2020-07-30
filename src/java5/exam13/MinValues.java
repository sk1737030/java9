package java5.exam13;

import java.util.stream.Stream;

public class MinValues extends ClassLoader {


    public int min(int... values) {
        int min = Integer.MAX_VALUE;

        for (int value : values) {
            min = Math.min(min, value);
        }

        minValeusHalper(min, values);

        return min;
    }

    private void minValeusHalper(int min, int[] values) {
        for (int value : values) {
            assert min <= value;
        }
    }
}
