package java3.exam14;

public class Exam14 {


    public static Runnable run(Runnable... runnables) {

        return () -> {
            for (Runnable runnable : runnables) {
                runnable.run();
            }
        };
    }
}
