package com.yen.courseV1;

// https://youtu.be/bF1iX6GbMw4?si=7p0lg23SWiCC6Gpz

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceObserver;
// import rx.Observable;
import java.util.concurrent.TimeUnit;

public class part8 {
  public static void main(String[] args) {

    disposasableExample1();
    //      disposasableExample2();
    //      disposasableExample3();
  }

  private static void disposasableExample1() {

    Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
    Disposable disposable = seconds.subscribe(l -> System.out.println("item = " + l));

    if (disposable.isDisposed()) {
      disposable.dispose();
    }
  }

  private static void disposasableExample2() {

    Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    seconds.subscribe(
        new Observer<Long>() {
          @Override
          public void onSubscribe(@NonNull Disposable d) {
            // note here
            compositeDisposable.add(d);
            System.out.println("d = " + d);
          }

          @Override
          public void onNext(@NonNull Long aLong) {}

          @Override
          public void onError(@NonNull Throwable e) {}

          @Override
          public void onComplete() {
            System.out.println("on Complete !");
          }
        });

    // NOTE!!! when no need instances, we dispose them via below
    compositeDisposable.dispose();
  }

  private static void disposasableExample3() {

      Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

      ResourceObserver<Long> resourceObserver = new ResourceObserver<Long>() {
          @Override
          public void onNext(@NonNull Long item) {

              System.out.println("item = " + item);
          }

          @Override
          public void onError(@NonNull Throwable e) {

          }

          @Override
          public void onComplete() {

          }
      };

      seconds.subscribe(resourceObserver);

      resourceObserver.dispose();
  }

}
