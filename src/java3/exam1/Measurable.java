package java3.exam1;

public interface Measurable {
    double getMeasure();

    static double average(Measurable[] objects) {
        int sum = 0;

        for (var i = 0; i < objects.length; i++) {
            sum += (objects[i]).getMeasure();
        }

        return sum / objects.length;
    }

    static String largeSt(Measurable[] objects) {
        int largeSt = 0;

        String largeStName = "";

        for (var i = 0; i < objects.length; i++) {
            if(largeSt < objects[i].getMeasure()){
                largeStName = ((Employee) objects[i]).getName();
            }

        }
        return largeStName;
    }
}
