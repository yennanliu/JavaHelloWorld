package com.yen.courseV1;

// https://youtu.be/yWdl58IXuPQ?si=NfR3e0V24xWjk1Sc

import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import rx.Completable;
import rx.Observable;
import rx.functions.Action0;

public class part3 {
  public static void main(String[] args) {

    // Observable.range
    Observable<Integer> observable = Observable.range(2, 5);

    observable.subscribe(
        item -> {
          System.out.println(item);
        });

    // Observable.interval
    Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

    //      intervalObservable.subscribe(item -> {
    //          System.out.println(item);
    //      });

    // Observable.interval
    Observable<Long> timeObservable = Observable.timer(5, TimeUnit.SECONDS);

    timeObservable.subscribe(
        item -> {
          System.out.println("5 sec passed " + item);
        });

    //Action action2 = () -> System.out.println("hello world!!");
    Action action =
        new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent = " + e);
          }
        };

    Completable completable = Completable.fromAction((Action0) action);

    completable.subscribe(() -> {
        System.out.println("---> Action ends");
    });


    // to avoid program completed while intervalObservable, timeObservable are still running
    new Scanner(System.in).nextLine();
  }
}
