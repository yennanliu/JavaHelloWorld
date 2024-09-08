package com.yen.CourseV1;

// https://youtu.be/l4zfIkRsT_8?si=3geV4TPwRFlq7s1g

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

public class part5 {
  public static void main(String[] args) {

    Completable completable = createCompletable();

    completable.subscribe(new CompletableObserver() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        System.out.println("d = " + d);
      }

      @Override
      public void onComplete() {
        System.out.println("op is completed !");

      }

      @Override
      public void onError(@NonNull Throwable e) {

      }
    });

  }

  private static Completable createCompletable(){
    return Completable.fromAction(deleteItemFromDBAction());
  }

  // NOTE !!! use io.reactivex.rxjava3.functions.Action
  private static Action deleteItemFromDBAction(){

    return new Action() {
      @Override
      public void run() throws Throwable {
        System.out.println("DB delete OK");
      }
    };
  }

}
