package java4.book4_1.jang1_2;

public class ConcurrentWorker extends Worker {
    @Override
    public void work() {
        Thread t = new Thread(super::work);
        t.start();
    }

    public static void main(String[] args) {

    }
}
