package com.yen.courseV1;

// https://youtu.be/k4s7khhHieY?si=VNYFqxnA40etb1kh

import rx.Observable;
import rx.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class part7 {
  public static void main(String[] args) throws InterruptedException {

    //coldObservableExample();
    hotObservableExample();
  }

    private static void coldObservableExample(){

      Observable observable = Observable.just("a", "b", "c");

      observable.subscribe(item -> {System.out.println("Observable 1 - " + item);});
      observable.subscribe(item -> {System.out.println("Observable 2 - " + item);});
      observable.subscribe(item -> {System.out.println("Observable 3 - " + item);});
    }

  private static void hotObservableExample() throws InterruptedException {

    ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS).publish();

    // below is necessary, or code not work
    observable.connect();

    observable.subscribe(item -> {
      System.out.println("Observable 1 - " + item);
    });

    Thread.sleep(5000);

    observable.subscribe(item -> {
      System.out.println("Observable 2 - " + item);
    });

    Thread.sleep(100000);
  }

}

