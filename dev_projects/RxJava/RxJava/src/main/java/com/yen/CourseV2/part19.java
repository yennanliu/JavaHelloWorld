package com.yen.CourseV2;

// course 19
// https://youtu.be/w3NT4ltKT1s?si=xlhUdy5i2u_S75yL

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class part19 {
  public static void main(String[] args) throws IOException {

    // dispose
//    ReactiveSources.intNumbersFlux()
//        .subscribe(
//            number -> System.out.println(number),
//            err -> System.out.println("error = " + err),
//            () -> System.out.println("completed !!!"));

    ReactiveSources.intNumbersFlux().subscribe(new mySubscriber<>());

    System.out.println("press a key to end");
    System.in.read();
  }

}

class mySubscriber<T> extends BaseSubscriber<T> {

  public void hookOnSubscribe(Subscription subscription) {
    System.out.println("subscribe happened");
    // control the rate of flow (back pressure)
    request(3);
  }

  public void hookOnNext(T value) {
    System.out.println(value.toString() + " received");
    request(1);
  }
}
