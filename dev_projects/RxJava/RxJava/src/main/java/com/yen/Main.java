package com.yen;

import rx.Observable;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        /** part 1
         *
         *  https://youtu.be/7mbjhNCWqvs?si=nuGVikk2eSXVRqUE
         */
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("click on 1");
            emitter.onNext("click on 2");
            emitter.onNext("click on 3");
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