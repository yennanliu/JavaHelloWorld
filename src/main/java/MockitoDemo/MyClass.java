package MockitoDemo;

/**
 * -
 * https://stackoverflow.com/questions/8948916/mocking-logger-and-loggerfactory-with-powermock-and-mockito
 * -
 * https://vivifish.medium.com/java-%E5%96%AE%E5%85%83%E6%B8%AC%E8%A9%A6%E5%B7%A5%E5%85%B7-mockito-e5f0ce93579d
 */
public class MyClass {

  public static void main(String[] args) {

    MyClass myClass = new MyClass();
    System.out.println(myClass.toUpperCase("this is HELLOWORLD"));
  }

  public String toUpperCase(String input) {

    MyUtils myUtils = new MyUtils();
    myUtils.myPrint();
    System.out.println("input = " + input);

    return input.toUpperCase();
  }
}

class MyUtils {
  public String myPrint() {
    String msg = "this is myPrint!!!, current time = " + System.currentTimeMillis();
    // System.out.println(msg);
    return msg;
  }
}
