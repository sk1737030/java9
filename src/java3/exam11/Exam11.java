package java3.exam11;

import java.io.File;
import java.io.FileFilter;

public class Exam11 {
    public static void getSubDirectory(String path) {

        File file = new File(path);

        File[] files = file.listFiles((pathname) -> pathname.isDirectory());

        for(File file1 : files) {
            System.out.println(file1.getName());
        }
    }
}
