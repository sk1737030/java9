package java5.exam5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exam5 {
    public void copy(String from, String to) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(from));
            out = new PrintWriter(to);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /* null체크 해야함. */
            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }
        }
    }
}
