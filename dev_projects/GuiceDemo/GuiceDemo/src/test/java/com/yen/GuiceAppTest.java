//package com.yen;
//
//import com.google.inject.AbstractModule;
//import com.google.inject.Guice;
//import com.google.inject.Injector;
//import com.yen.service.MyInterface;
//import com.yen.service.RunningService;
//import com.yen.service.impl.Implementation_A;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//// https://blog.csdn.net/cunchi4221/article/details/107477193
//
//public class GuiceAppTest {
//
//    private Injector injector;
//
//    @Before
//    public void setUp(){
//        System.out.println("setUp");
//        injector = Guice.createInjector(new AbstractModule() {
//            @Override
//            protected void configure() {
//                //super.configure();
//                bind(MyInterface.class).to(Implementation_A.class);
//            }
//        });
//    }
//
//    @After
//    public void tearDown(){
//        System.out.println("tearDown");
//        injector = null;
//    }
//
//    @Test
//    public void test1(){
//
//        RunningService runningService = injector.getInstance(RunningService.class);
//
//        // TODO : fix error : java.lang.NullPointerException
//        Assert.assertSame("msg from impl : this is Implementation_A", runningService.print());
//
//        //System.out.println(123);
//    }
//
//
//}
