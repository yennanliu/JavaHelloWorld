package MockitoDemo;

/**
 * https://stackoverflow.com/questions/8948916/mocking-logger-and-loggerfactory-with-powermock-and-mockito
 *
 */
public class MyClass {


    public String toUpperCase(String input){

        MyUtils myUtils = new MyUtils();
        myUtils.myPrint();
        System.out.println("input = " + input);

        return input.toUpperCase();
    }

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        System.out.println(myClass.toUpperCase("this is HELLOWORLD"));
    }

}

class MyUtils{
    public String myPrint(){
        String msg = "this is myPrint!!!, current time = " + System.currentTimeMillis();
        //System.out.println(msg);
        return msg;
    }

}