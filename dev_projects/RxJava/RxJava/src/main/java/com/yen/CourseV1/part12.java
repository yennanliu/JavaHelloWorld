package com.yen.CourseV1;

// part 12 : Subject
// https://youtu.be/rhkPPFVw5Ns?si=O7c0MkjflPsPENAa

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.TimeUnit;

public class part12 {
  public static void main(String[] args) {

    /** example 1 : PublishSubject */
    // create 2 sources
    Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS);
    Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

    // create publish subjects
    Subject<Long> subject = PublishSubject.create();

    // subscribe to the publishSubject object
    subject.subscribe(item -> System.out.println("received item = " + item));

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

    /** example 2 : BehaviorSubject */
    Subject<Integer> subject2 = BehaviorSubject.create();

    subject2.subscribe(item -> System.out.println("person 1 listens to song = " + item));

    subject2.onNext(1);
    subject2.onNext(2);
    subject2.onNext(3);

    subject2.subscribe(item -> System.out.println("person 2 listens to song = " + item));

    /** example 3 : AsyncSubject */
    Subject<Integer> subject3 = AsyncSubject.create();

    subject3.subscribe(item -> System.out.println("person A listens to song = " + item));

    subject3.onNext(1);
    subject3.onNext(2);
    subject3.onNext(3);

    subject3.subscribe(item -> System.out.println("person B listens to song = " + item));

    subject3.onNext(4);

    subject3.onComplete();
  }
}
