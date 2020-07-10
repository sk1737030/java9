package java3.exam4;

import java.util.function.IntConsumer;

public interface IntSequence {
    boolean hasNext();

    int next();


    static IntSequence of(int... seq) {
        return new IntSequence() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return seq.length != index;
            }

            @Override
            public int next() {
                return seq[index++];
            }
        };
    }


    static IntSequence constant(int i) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {

                return i;
            }
        };
    }

}
