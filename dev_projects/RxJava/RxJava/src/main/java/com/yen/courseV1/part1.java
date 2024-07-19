package com.yen.courseV1;

// https://youtu.be/7mbjhNCWqvs?si=GtCY3Wk5AFTdjYgS

import rx.Observable;

public class part1 {
    public static void main(String[] args){

        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("click on 1");
            emitter.onNext("click on 2");
            emitter.onNext("click on 3");

            emitter.onCompleted();
        });

        observable.subscribe(item -> {
            System.out.println(item);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("op complete !");
        });

    }
}
