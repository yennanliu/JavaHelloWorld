package com.yen;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yen.example0.module.CalculatorModule;
import com.yen.example0.module.MyModule;
import com.yen.example0.service.impl.CalculatorService;
import com.yen.example0.service.RunningService;
import com.yen.example1.*;

// import javax.inject.Inject;

public class GuiceApp {
    public static void main(String[] args) {

        System.out.println("Guice Hello world !!!");

        /** demo 1 */
        // NOTE !!! init injection via Guice
        Injector injector = Guice.createInjector(new MyModule());

        // inject via Guice, and get the instance
        RunningService runningService = injector.getInstance(RunningService.class);
        String res = runningService.print();
        System.out.println(">>> res = " + res);

        System.out.println("===========");

        /** demo 2 */
        Injector injector1 = Guice.createInjector(new CalculatorModule());

//    Calculator calculator =  injector1.getInstance(Calculator.class);
//    System.out.println("addition = " + calculator.addition(1,2));
//    System.out.println("calculator = " + calculator);
//
//    Calculator calculator2 =  injector1.getInstance(Calculator.class);
//    System.out.println("calculator2 = " + calculator2);

        System.out.println("===========");

        /** demo 3 */
        // https://youtu.be/fe1n8VIXZ-k?si=403VnOglnyZswRZQ&t=591
        /**
         *  NOTE!!!
         *
         *   below code will fail if not adding @Inject at CaculatorService
         *
         *   e.g. :
         *
         *     @Inject
         *     private Calculator calculator;
         *
         *   error:
         *
         *   Exception in thread "main" java.lang.NullPointerException
         * 	at com.yen.CaculatorService.calculate(CaculatorService.java:15)
         * 	at com.yen.GuiceApp.main(GuiceApp.java:41)
         *
         */
        CalculatorService calculatorService = injector1.getInstance(CalculatorService.class);
        System.out.println("addition = " + calculatorService.calculate(1, 2, "add"));

        System.out.println("===========");

        /** demo 4 */
        // create injector
        Injector injector2 = Guice.createInjector(new AnimalModule());

        // get instance
        Host host = injector2.getInstance(Host.class);

        // call instance method
        System.out.println(host.getAnimal().eat());

        System.out.println("===========");

        /** demo 5 */
        Injector injector3 = Guice.createInjector(new DummyModule());
        ThirdPartyClass thirdPartyClass = injector3.getInstance(ThirdPartyClass.class);

        //ThirdPartyClass t = new ThirdPartyClass();
//    ThirdPartyClass.print();
//    thirdPartyClass.

        System.out.println(thirdPartyClass.getClass());
        System.out.println(thirdPartyClass.print());

    }

}