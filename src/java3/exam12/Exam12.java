package java3.exam12;

import java.io.File;

public class Exam12 {
    public static void getSubFileName(String path,final String target) {

        File file = new File(path);

        File[] files = file.listFiles((dir, name) -> name.endsWith(target));

        for(File file1 : files) {
            System.out.println(file1.getName());
        }
    }
}
