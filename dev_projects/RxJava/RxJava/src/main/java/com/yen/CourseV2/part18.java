package com.yen.CourseV2;

// course 18
// https://youtu.be/Ih5bqUU_QDg?si=OZ67sQkaRTt1Ng7K

import java.io.IOException;

public class part18 {
  public static void main(String[] args) throws IOException {

    ReactiveSources.intNumberMono()
        .subscribe(
            number -> System.out.println(number),
            err -> System.out.println("error = " + err),
            () -> System.out.println("completed !!!"));

    ReactiveSources.intNumbersFlux()
        .subscribe(
            number -> System.out.println(number),
            err -> System.out.println("error = " + err),
            () -> System.out.println("completed !!!"));

    System.out.println("press a key to end");
    System.in.read();
  }
}
