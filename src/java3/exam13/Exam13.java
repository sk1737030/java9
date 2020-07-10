package java3.exam13;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class Exam13 {
    public static void getSubDirectoryWithOrder(String path) {
        List<File> fileList = Arrays.asList(new File(path).listFiles());

        Collections.shuffle(fileList);

        File[] files =  fileList.toArray(new File[fileList.size()]);

        Arrays.sort(files, (o1, o2) -> {
            if(o1.isDirectory() && o2.isFile()) {
                return -1;
            }else if(o1.isFile() && o2.isDirectory()){
                return 1;
            }
                return o1.compareTo(o2);
        });

        for (File file : files) {
            System.out.println(file);
        }
    }
}
