package java4.book4_1.jang3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public enum Operation {
    ADD {
        public int eval(int arg1, int arg2) {
            return arg1 + arg2;
        }
    },
    SUBTRACT {
        public int eval(int arg1, int arg2) {
            return arg1 - arg2;
        }
    },
    MULTIPLY {
        public int eval(int arg1, int arg2) {
            return arg1 * arg2;
        }
    },
    DIVIDE {
        public int eval(int arg1, int arg2) {
            return arg1 / arg2;
        }
    };

    public abstract int eval(int arg1, int arg2);

    public static void main(String[] args) throws MalformedURLException {
        InputStream stream = Class.class.getResourceAsStream("config.txt");
        Scanner in = new Scanner(stream);

        URL[] urls = {
                new URL("file:///path/to/directory/"),
                new URL("file:///path/to/jarfile.jar")
        };
        String className = "com.mycompany.Entry";
        try (URLClassLoader urlClassLoader = new URLClassLoader(urls)) {
            Class<?> cl = Class.forName(className, true, urlClassLoader);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


