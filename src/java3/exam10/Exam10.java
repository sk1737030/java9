package java3.exam10;

import java.util.ArrayList;

public class Exam10 {
    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void runInOrder(Runnable... tasks) {
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
            threadArrayList.add(thread);
        }

        try {
            for (Thread thread : threadArrayList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
