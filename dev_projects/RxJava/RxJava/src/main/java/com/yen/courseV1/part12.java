package com.yen.courseV1;

// part 12 : Subject
// https://youtu.be/rhkPPFVw5Ns?si=O7c0MkjflPsPENAa

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.TimeUnit;

public class part12 {
  public static void main(String[] args) {

    // create 2 sources
    Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS);
    Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

    // create publish subjects
    Subject<Long> subject = PublishSubject.create();

    // subscribe to the publishSubject object
    subject.subscribe(item -> System.out.println(item));

    // we will need to tell our subject that
    // it will receive items from 2 different sources
    source1.subscribe(subject);
    source2.subscribe(subject);

    // prevent out program from exciting
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
