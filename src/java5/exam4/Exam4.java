package java5.exam4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Exam4 {
    public ReturnErrorCode readValues(String filename) throws IOException {

        ArrayList<Double> returnDoubles = new ArrayList<>();
        double c = 0;

        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename))) {
            String str = null;

            while ((str = in.readLine()) != null) {
                c = Double.parseDouble(str);
                returnDoubles.add(c);
            }
        }catch (Exception e) {
            return  new ReturnErrorCode(500, "IOException");
        }

        return new ReturnErrorCode(200, "success");
    }

    public ReturnErrorCode sumOfValues(String filename)  {
        double d = 0;

        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename))) {
            String str = null;
            while ((str = in.readLine()) != null) {
                d += Double.parseDouble(str);
            }
        } catch (Exception e) {
            return new ReturnErrorCode(500, "IOException");
        }
        return new ReturnErrorCode(200, "success");
    }
}
