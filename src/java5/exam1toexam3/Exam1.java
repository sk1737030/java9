package java5.exam1toexam3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Exam1 {

    /**
     * 부동소수점 수가 저장되어 있는 파일을 읽는다.
     *
     * @param filename 
     * @return
     * @throws NullPointerException          filename이 null인 경우
     * @throws java.io.FileNotFoundException 파일을 찾을 수 없을 때
     * @throws NumberFormatException         부동소수점이 아닌 다른 값이 있을 때
     * @throws IOException
     */
    public ArrayList<Double> readValues(String filename) throws IOException {

        ArrayList<Double> returnDoubles = new ArrayList<>();
        double c = 0;

        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename))) {
            String str = null;

            while ((str = in.readLine()) != null) {
                c = Double.parseDouble(str);
                returnDoubles.add(c);
            }
        }

        return returnDoubles;
    }

    public double sumOfValues(String filename) throws IOException {
        double d = 0;

        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename))) {
            String str = null;
            while ((str = in.readLine()) != null) {
                d += Double.parseDouble(str);
            }
        } catch (IOException e) {
            //System.err.println(e);

            throw e;
        }

        return d;
    }
}
