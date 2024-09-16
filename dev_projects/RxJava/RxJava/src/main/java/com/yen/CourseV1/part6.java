package com.yen.CourseV1;

// https://youtu.be/Kx1S_wtwA2g?si=z4iIAVShgn9Kxvmi

// TODO : complete this

import static java.lang.Thread.sleep;

// import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Flowable;
import rx.Observable;
import rx.schedulers.Schedulers;

// import io.reactivex.rxjava3.core.Scheduler;

public class part6 {
  public static void main(String[] args) {

    // synchronousObservableExample();
    asyncObservableExample();
    //      asyncFlowableExample();
  }

  private static void synchronousObservableExample() {
    Observable.range(1, 1000000)
        .map(id -> new Item(id))
        .subscribe(
            item -> {
              try {
                sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("received Item " + item.id + "\n");
            });
  }

  private static void asyncObservableExample() {
    Observable.range(1, 1000000)
        .map(Item::new)
        .observeOn(Schedulers.io()) // package rx.schedulers.Schedulers;
        .subscribe(
            item -> {
              try {
                sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("received Item " + item.id + "\n");
            });
    try {
      sleep(Long.MAX_VALUE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void asyncFlowableExample() {
    Flowable.range(1, 100000)
        .map(Item::new)
        // TODO : fix below
        // .observeOn(Scheduler)
        // .observeOn(Schedulers.io()) // package rx.schedulers.Schedulers;
        .subscribe(
            item -> {
              sleep(1000);
              System.out.println("received Item " + item.id + "\n");
            });
    try {
      sleep(Long.MAX_VALUE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
