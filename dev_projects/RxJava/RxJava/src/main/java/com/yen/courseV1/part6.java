package com.yen.courseV1;

// https://youtu.be/Kx1S_wtwA2g?si=z4iIAVShgn9Kxvmi

// TODO : complete this

import static java.lang.Thread.sleep;

import rx.Observable;

public class part6 {
  public static void main(String[] args) {}

  private static void synchronousObservableExample() {
    Observable.range(1, 1000000)
        .map(id -> new Item(id))
        .subscribe(
            item -> {
              try {
                sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("received Item " + item.id + "\n");
            });
  }
}