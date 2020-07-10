package java3.exam9;

public class Gretter implements Runnable {

    private int n;
    private String target;

    public Gretter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        System.out.println("dsfopjsdpfjsdopf");

        for (int i = 0; i <= n; i++) {

            System.out.println("hellow " + target);
            try{
                Thread.sleep(1000);

            }catch (Exception e) {
            }
        }
        System.out.println("dsfopjsdpfjsdopf");
    }

}
