package java5.exam09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exam09 {
    public void readWithAutoClose(String path) {


        try (AutoCloseable auto = readCloseHelper(new ReentrantLock(), () -> System.out.println(1 / 0))) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AutoCloseable readCloseHelper(Lock lock, Runnable run) {
        lock.lock();
        try {
            run.run();
        } finally  {

            return lock::unlock;
        }
    }
}
