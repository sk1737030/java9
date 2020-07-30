##### 1.부동소수점 수가 지정된 파일을 읽는 public ArrayList<Double> readValues(Stringfilnename) throws... 메서드를 작성하라. 파일을 열 수 없거나 입력 중 일부가 부동소수점 수가 아니면 적절한 예외를 던져야 한다.
   
##### 2. 연습문제 1에서 만든 메서드를 호출해서 파일에 들어 있는 값의 합계를 반환하는 public dobule sumofValues(String filename) throws... 메서드를 작성하라. 예외가 일어나면 호출한 쪽으로 전파해야 한다.

##### 3. 연습문제 2에서 만든 메서드를 호출해서 나온 결과를 출력하는 프로그램을 작성하라. 예외가 일어나면 잡아서 사용자에게 오류 상황을 전파하라.
   
<pre>
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

</pre>


##### 4. 연습문제 1~3을 반복하라 이번에는 예외를 사용하지말아야 한다. 그 대신 readValues와 sumOfValues에서 어떤 종류의 오류 코드를 반환하게 만들어라.
<pre>
@ToString
@Getter
@RequiredArgsConstructor
public class ReturnErrorCode  {
    private final int code;
    private final String msg;

}
</pre>

<pre>
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
</pre>
<pre>
@Test
public void exam04() {

    Exam4 exam1 = new Exam4();
    ReturnErrorCode re = null;
    try {
        re = exam1.readValues("C:\\ch05\\double.txt");
    } catch (Exception e) {
        Assert.assertEquals(500, re.getCode());
    }

    ReturnErrorCode re2 = exam1.sumOfValues("C:\\ch05\\double.txt");

    Assert.assertEquals(500, re2.getCode());
}
</pre>

##### 5. 5.1.5절에서 다룬 Scanner와 PrintWriter를 이용하는 코드를 포함하는 메서드를 구현하라. 하지만 try-with-resources 문을 사용하지 않아야 한다. 대신 catch 절을 이용한다. 두 객체를 올바르게 생성 했다면 확실히 닫아야 한다. 그리고 다음과 같은 상황을 고려해야 한다.
  * Scanner 생성자는 예외를 던진다.
  * PrintWriter 생성자는 예외를 던진다.
  * hasNext, next, println은 예외를 던진다.
  * out.close()는 예외를 던진다.
  * in.close()는 예외를 던진다.


<pre>
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
            /* 생성된 순서의 역순으로 close 해야한다. */
            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }
        }
    }
}
</pre>

#####6. 5.1.6절에는 catch와 finally 절이 있지만 잘못된 try 문 예제가 있다.
  * (a) finally 절에서 예외를 잡는 방법
  *  (b) try/finally 문을 포함하는 try/catch문
  *  (c) catch 절을 이용하는 try-with-resources문으로 코드를 고쳐라.
  
<pre>
BufferedReader in = null;
     try {
         in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8);

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         if (in != null) {
             try {
                 in.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
 </pre> 
 <pre>
BufferedReader in = null;
     try {
         try {
             in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8);
         } finally {
             if (in != null) {
                 try {
                     in.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 </pre> 
  
<pre>
try (BufferedReader in = Files.newBufferedReader(Paths.get("C:\\ch05\\double.t333xt"), StandardCharsets.UTF_8)) {
    // in

} catch (IOException e) {
    e.printStackTrace();
}
</pre>  
  
##### 7. 다음 코드를 보자.
<pre>
try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
PrintWriter out = new PrintWriter(outputFile)) {
    while (in.hasNext())
        out.println(in.next().toLowerCase());       
}
</pre>
이 코드가 다음 코듭돠 나은 이유를 설명하라.
<pre>
Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
PrintWriter out = new PrintWriter(outputFile);
try(in; out) {
    while(in.hasNext())
        out.println(in.next().toLowerCase());
}
</pre>

아래 코드는 위험한 점이 Scanner를 생성 하고 out을 생성 할때 예외를 던지게 되면 in.close를 호출하지 못하게된다.

 
##### 8. 이번 연습문제를 풀려면 java.util.Scanner 클래스의 소스 코드를 읽어야 한다. Scanner를 사용할 때 입력이 잘못되면 Scanner 클래스는 해당 입력 예외를 잡아내고 입력을 소비하던 리소스를 닫는다. 리소스를 닫는 작업에서 예외를 던지면 어떻게 될까? 이 구현은 try-with-resources 문에서 억제된 예외를 다루는 방법에 어떤 영향을 미쳤는가?
<pre>
/*
*
* @since   1.5
*/
public final class Scanner implements Iterator<String>, Closeable {

    // Tries to read more input. May block.
    private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();
        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());
    
        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }
        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }
        if (n > 0)
            needInput = false;
        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }
}
  /**
     * Closes this scanner.
     */
    public void close() {
        if (closed)
            return;
        if (source instanceof Closeable) {
            try {
                ((Closeable)source).close();
            } catch (IOException ioe) {
                lastException = ioe;
            }
        }
        sourceClosed = true;
        source = null;
        closed = true;
    }
</pre>

이 ScannerClass는 자바 1.5에 추가 되었다. 1.5에는 1.7에서 추가된 AutoCloseable 없었을 때라 에러가 발생 했을 때 억제된 에외를 처리하기 위한 방법인거 같음. 에러가 발생시 lastException에 에러를 저장한다.
   그리고 만약 소스를 닫는 도중에 에러를 던지면  lastException에 에러를 저장한다.

<pre>
javaTest.MyException at javaTest.MyResource.out(ExceptionTest_1.java:27) at javaTest.ExceptionTest_1.main(ExceptionTest_1.java:10)
 Suppressed: javaTest.CloseException at javaTest.MyResource.close(ExceptionTest_1.java:23) at javaTest.ExceptionTest_1.main(ExceptionTest_1.java:11)

출처: https://dololak.tistory.com/67 [코끼리를 냉장고에 넣는 방법]
</pre>
try-with-resource에서 억제된 예외 발생시 suppressed예외로 첨부한다. 
 
##### 9. try-with-resources 문에서 ReentrantLock 을 사용할 수 있도록 헬퍼 메서드를 설계하라. 이 메서드는 lock을 호출하고 AutoCloseable을 반홯내야한다. 또 해당 AutoCloseable은 close 메서드에서 unlock을 호출하고 예외는 던지지 않아야 한다.
<pre>
package java5.exam09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exam09 {
    public void readWithAutoClose(String path) {


        try (AutoCloseable auto = readCloseHelper(new ReentrantLock(), () -> System.out.println(1 / 0))) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AutoCloseable readCloseHelper(Lock lock, Runnable run) {
        lock.lock();
        try {
            run.run();
        } finally {
            return lock::unlock;
        } // finally에 reutrn을 던저버리면 try구문에 생긴 예외를 가려버린다.
    }
}
</pre> 
  
<<<<<<< HEAD
  
  
=======
##### 10. Scanner와 PrintWriter 클래스의 메서드는 초보 개발자가 사용하기 쉽게 하려고 검사 예외를 던지지 않는다. 읽기나 쓰기 도중에 오류가 일어났는지 일어나지 않았는지 어떻게 알 수 있을까? 생성자는 검사 예외를 던질 수 있다는 점에 주의해야 한다. 이 점이 초보자가 사용하기 쉽게 만든다는 목표를 저해하는 이유를 설명하라.
 
<pre>
 public final class Scanner { 
 ....
  // Tries to read more input. May block.
    private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();
        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());
    
        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }
        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }
        if (n > 0)
            needInput = false;
        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }
...
</pre>
 
에러를 바로 던지지 않고 일단 lastException에 저장한다. 그러다보니 컴파일중에 나타나는 것이아니라 실행중에 에러가 발생한다. 실행중에 에러가 디버깅이 힘들다보니 초보 프로그래머에게는 어려울 수 있다.
   읽거나 쓰기 도중에 오류가 일어났는지 여부를 알 수 있는 방법은 입력 할 때 한 번 검증을 하는게 어떨까...
   
   
##### 11.재귀로 factorial 메서드를 작성하라. 이 메서드에서는 값을 반환하기 전에 모든 스택 프레임(stack frame)를 출력해야 한다. 이떤 종류든 예외 객체를 생성해서(그렇지만 던지지는 말아야 한다) 5.1.8에서 설명한 스택 추적을 얻어라.
<pre>
package java5;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial {
public static ArrayList<Exception> ex = new ArrayList<>();
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {//0! 일 경우
    
    
            return BigInteger.ONE;
        } else
            try {
                throw new Exception();
            } catch (Exception e) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                e.printStackTrace(new PrintWriter(out));
                ex.add(e);
            }
            
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
</pre>

#####12. Objects.requireNonNull(obj)와 assert obj != null을 사용하는 경우를 비교해서 각각을 적절하게 사용하는 예를 제시하라.
2 개의 차이점은 
<pre>
this.description = Objects.requireNonNull(direcrtion, "direction must not be null") 
</pre>
이런식으로 추가적으로 던져 줄 수 있고 null일경우 다른 값을 삽입 할 수 도있음. 

<pre> asset x >= 0;</pre>
음수가 아님을 단정할 수 잇다.

#####13. int min(int[] values) 메서드를 작성하라. 이 메서드는 가장 작은 값을 반환하기
<pre>
package java5.exam13;

import java.util.stream.Stream;

public class MinValues extends ClassLoader {


    public int min(int... values) {
        int min = Integer.MAX_VALUE;

        for (int value : values) {
            min = Math.min(min, value);
        }

        minValeusHalper(min, values);

        return min;
    }

    private void minValeusHalper(int min, int[] values) {
        for (int value : values) {
            assert min <= value;
        }
    }
}
</pre>
assert 단정을 켯을 때 -ea 1064100
assert 단정을 껏을 때 -da 804500
>>>>>>> fa36a0f... 문제 추가 5장 추가 13번까지
