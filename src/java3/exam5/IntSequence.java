package java3.exam5;

import java.util.function.IntConsumer;

public interface IntSequence {
    boolean hasNext();

    int next();

    static IntSequence constant(int i, IntConsumer intConsumer) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {
                intConsumer.accept(i);
                return i;
            }
        };
    }
}
