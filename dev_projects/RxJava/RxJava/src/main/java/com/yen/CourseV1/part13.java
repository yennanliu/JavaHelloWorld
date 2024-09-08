package com.yen.CourseV1;

// part 13 : Custom operator
// https://youtu.be/xMY0pVrLJgY?si=WCQcYoowGEXP0oVw

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observers.DisposableObserver;
//import rx.Observable;

public class part13 {
  public static void main(String[] args) {

    Observable.just(1, 2, 3, 4)
        //.filter(item -> item % 2 == 0) // V1
        .lift(takeEven()) // V2 (do above logic with custom operator)
        .subscribe(item -> System.out.println(item));
  }

  // custom operator
  private static ObservableOperator<Integer, Integer> takeEven() {
    // return null;
    return new ObservableOperator<Integer, Integer>() {
      @Override
      public @NonNull Observer<? super Integer> apply(@NonNull Observer<? super Integer> observer)
          throws Throwable {
        return new DisposableObserver<Integer>() {
          @Override
          public void onNext(@NonNull Integer item) {
              if(item % 2 == 0){
                  observer.onNext(item);
              }
          }

          @Override
          public void onError(@NonNull Throwable e) {}

          @Override
          public void onComplete() {}
        };
      }
    };
  }

}
