package com.yen.courseV1;

// https://youtu.be/ApUUN55V2RE?si=zOpzZ14He9IzmqGZ

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class part2 {
  public static void main(String[] args) {

      /** Example 1 */
      // Observable via just
      Observable<String> observable = Observable.just("item 1", "item 2");

      List<Integer> numbers = new ArrayList<>();
      numbers.add(1);
      numbers.add(2);

      // implement Observer
      Observer<String> observer = new Observer<String>() {
          @Override
          public void onCompleted() {
              System.out.println("On Completed called !");
          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onNext(String s) {
              System.out.println("onNext -- " + s);
          }
      };

      // run
      observable.subscribe(observer);

      /** Example 2 */

      // Observable from iterable
      Observable<Integer> observable2 = Observable.from(numbers);

      Observer<Integer> observer2 = new Observer<Integer>() {
          @Override
          public void onCompleted() {
              System.out.println("On Completed called !");
          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onNext(Integer integer) {
              System.out.println("onNext -- " + integer);
          }
      };

      // run
      observable2.subscribe(observer2);
  }

}
