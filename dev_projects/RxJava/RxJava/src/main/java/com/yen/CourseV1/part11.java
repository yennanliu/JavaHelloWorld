package com.yen.CourseV1;

// part 11 : Operators - utility and error handling
// https://youtu.be/nY1Phpp0BkA?si=fN_Aavl9xD2xs3FT

import rx.Observable;
import rx.schedulers.Schedulers;

public class part11 {
  public static void main(String[] args) {

    // example 1 : observeOn
    System.out.println(Thread.currentThread().getName());

    Observable.just("hello world !!!")
        .observeOn(Schedulers.newThread())
        .subscribe(
            item -> {
              System.out.println(Thread.currentThread().getName());
              System.out.println(item);
            });

    System.out.println("=================");

    // example 2 : subscribeOn
    System.out.println(Thread.currentThread().getName());

    Observable.just("hello world !!!")
        .subscribeOn(Schedulers.newThread())
        .subscribe(
            item -> {
              System.out.println(Thread.currentThread().getName());
              System.out.println(item);
            });

    // example 3 : doOnNext
    Observable.just(1, 2)
        .doOnNext(item -> System.out.println("log some ingo"))
        .subscribe(
            item -> {
              System.out.println(item);
            });

    // example 4 : retry
    Observable.just(2, 1, 0)
        .map(item -> 2 / item)
        .retry(1)
        .subscribe(
            item -> {
              System.out.println(item);
            },
            throwable -> System.out.println(throwable.getMessage()));
  }

}
