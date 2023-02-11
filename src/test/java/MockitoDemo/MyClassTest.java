package MockitoDemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 *  mockito demo 1
 *      - https://github.com/yennanliu/LambdaHelloWorld/blob/master/lab2/simple-handler/src/test/java/com/yen/SimpleHandlerTest.java
 *      - https://stackoverflow.com/questions/8948916/mocking-logger-and-loggerfactory-with-powermock-and-mockito
 *      - https://vivifish.medium.com/java-%E5%96%AE%E5%85%83%E6%B8%AC%E8%A9%A6%E5%B7%A5%E5%85%B7-mockito-e5f0ce93579d
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

        MyUtils mock = Mockito.mock(MyUtils.class);

        // https://www.baeldung.com/mockito-unnecessary-stubbing-exception
        lenient().when(myUtils.myPrint()).thenReturn("this is mock msg");
        Assert.assertEquals("HELLO WORLD", myClass.toUpperCase("heLLo World"));
        // verify is method is called
        //Mockito.verify(mock).myPrint();
    }

    @Test
    public void test2(){

        List<Integer> mock =  Mockito.mock(List.class);
        mock.add(1);
        // verify is method is called
        Mockito.verify(mock).add(1);
    }

    @Test
    public void test3(){
        MyClass myClass = new MyClass();
        myClass.toUpperCase("heLLo World");
        System.out.println(123);
    }

}