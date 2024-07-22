package com.yen.courseV1;

// part 15 : Threading - observeOn()
// https://youtu.be/9yk3vlalj3E?si=G0vJk_jI90WQlIym

//import rx.Observable;
//import rx.schedulers.Schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class part15 {
  public static void main(String[] args) {

    /** example 1 */
    Observable.just("hello world!")
        .subscribeOn(Schedulers.io()) // NOTE here
        .doOnNext(item -> System.out.println("emit item : " + Thread.currentThread().getName()))
        .observeOn(Schedulers.single()) // NOTE here
        .subscribe(item -> System.out.println("observe item : " + Thread.currentThread().getName()));

    // prevent app from exciting
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
