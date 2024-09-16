package com.yen.CourseV1;

// part 14 : Threading - subscribeOn()
// https://youtu.be/4menosDtstk?si=G2hBbjGornntY0BT

import rx.Observable;
import rx.schedulers.Schedulers;

public class part14 {
  public static void main(String[] args) {

    /**
     * Example 1 : subscribeOn(Schedulers.computation())
     *
     * <p>1) when main thread meet ".subscribeOn(Schedulers.computation())", it will proceed to next
     * lines, but NOT waiting till "Observable.just(1, 2, 3, 4, 5) subscribe logic" to complete
     */
    Observable.just(1, 2, 3, 4, 5)
        .doOnNext(
            item ->
                System.out.println(
                    "push item " + item + " on " + Thread.currentThread().getName() + " thread"))
        .subscribeOn(
            Schedulers
                .computation()) // // NOTE !!! with Schedulers.computation(), we NO LONGER USE main
                                // thread, but use thread such as RxComputationThreadPool-1  ...
        .subscribe(
            item ->
                System.out.println(
                    "Received item "
                        + item
                        + " on "
                        + Thread.currentThread().getName()
                        + " thread \n"));

    // prevent main thread to finish
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
