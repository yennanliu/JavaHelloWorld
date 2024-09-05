package com.yen;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yen.module.MyModule;
import com.yen.service.RunningService;

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


    /** demo 2 */
    Injector injector1 = Guice.createInjector(new CalculatorModule());
    Calculator calculator =  injector1.getInstance(Calculator.class);
    System.out.println("addition = " + calculator.addition(1,2));

  }

}