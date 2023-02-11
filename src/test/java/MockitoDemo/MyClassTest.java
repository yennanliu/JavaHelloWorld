package MockitoDemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

/**
 *  mockito demo 1
 *      - https://github.com/yennanliu/LambdaHelloWorld/blob/master/lab2/simple-handler/src/test/java/com/yen/SimpleHandlerTest.java
 *      - https://stackoverflow.com/questions/8948916/mocking-logger-and-loggerfactory-with-powermock-and-mockito
 *      - mock no need class/method in an unit test
 */
@ExtendWith(MockitoExtension.class)
class MyClassTest {

    @Mock
    MyUtils myUtils;

//    @BeforeEach
//    public void setup(){
//
//        // when "Logger.getLogger(MyClass.class.getName())" is called, return the mock logger we have
//        //when(loggerFactory.getLogger("MyClass")).thenReturn(logger);
//        //when(myClass.toUpperCase()).thenReturn(myClass);
//
//        doAnswer(call -> {
//            System.out.println("this is mock msg");
//            return null;
//        }).when(myClass).myPrint();
//
//        myClass = new MyClass();
//    }
//
//    @Test
//    public void shouldReturnUpperCase(){
//
//        when(myClass.toUpperCase(anyString())).thenReturn("handleRequest");
//        Assertions.assertEquals("HELLO WORLD!", myClass.toUpperCase("hello world!"));
//    }


    @Test
    public void test1(){

        MyClass myClass = new MyClass();

        // https://www.baeldung.com/mockito-unnecessary-stubbing-exception
        lenient().when(myUtils.myPrint()).thenReturn("this is mock msg");
        Assert.assertEquals("HELLO WORLD", myClass.toUpperCase("heLLo World"));
    }

    @Test
    public void test2(){
        MyClass myClass = new MyClass();
        myClass.toUpperCase("heLLo World");
        System.out.println(123);
    }

}