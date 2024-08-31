package com.yen;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yen.module.MyModule;
import com.yen.service.RunningService;

// import javax.inject.Inject;

public class GuiceApp {
  public static void main(String[] args) {

    System.out.println("Guice Hello world !!!");

    // NOTE !!! init injection via Guice
    Injector injector = Guice.createInjector(new MyModule());

    // inject via Guice, and get the instance
    RunningService runningService = injector.getInstance(RunningService.class);
    String res = runningService.print();
    //System.out.println(">>> res = " + res);
  }

}