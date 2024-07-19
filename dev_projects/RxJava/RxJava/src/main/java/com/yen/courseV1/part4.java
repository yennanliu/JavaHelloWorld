package com.yen.courseV1;

// https://youtu.be/EIwAerzQDvA?si=NQNL6Lgl9tc9qsU8

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;


public class part4 {
  public static void main(String[] args) {

      /** Example 1 : Single
       *
       *  Single : ONLY emit once and ONLY one item, other situation treated as error
       */
      //  Single<String>, NOTE how this different from regular Obervable
      Single<String> single = createSingle();
      single.subscribe(new SingleObserver<String>(){
          @Override
          public void onSubscribe(@NonNull Disposable d) {

          }

          @Override
          public void onSuccess(@NonNull String s) {
              System.out.println("(onSuccess) s = " + s);
          }

          @Override
          public void onError(@NonNull Throwable e) {
              System.out.println("(onError) = " + e.getMessage());
          }
      });

      /** Example 2 : Maybe
       *
       *  Maybe : emit one or no item
       */

      // Maybe
      Maybe<String> maybe = createMaybe();

      maybe.subscribe(new MaybeObserver<String>() {
          @Override
          public void onSubscribe(@NonNull Disposable d) {

          }

          @Override
          public void onSuccess(@NonNull String s) {
              System.out.println("(onSuccess) s = " + s);
          }

          @Override
          public void onError(@NonNull Throwable e) {
              System.out.println("(onError) = " + e.getMessage());
          }

          @Override
          public void onComplete() {
              System.out.println("completed! no new content");
          }
      });

  }

    public static Single<String> createSingle(){
        return Single.create(emitter -> {
            String user = fetchUser();
            if (user != null){
                emitter.onSuccess(user);
            }else{
                emitter.onError(new Exception("user not found"));
            }
        });
    }

    public static String fetchUser(){
      //return "May";
      return null;
    }

    public static Maybe createMaybe(){
      return Maybe.create(emitter -> {
          String newContent = readFile();
          if (newContent != null){
              emitter.onSuccess(newContent);
          }else{
              emitter.onComplete();
          }
      });
    }

    public static String readFile(){
      //return "content of some file";
      return null;
    }

}

