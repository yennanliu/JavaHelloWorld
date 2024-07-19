package com.yen.courseV1;

// https://youtu.be/l4zfIkRsT_8?si=3geV4TPwRFlq7s1g

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class part5 {
  public static void main(String[] args) {

    Completable completable = createCompletable();

  }

  private static Completable createCompletable(){
    return Completable.fromAction(deleteItemFromDBAction());
  }

  // NOTE !!! use io.reactivex.rxjava3.functions.Action
  private static Action deleteItemFromDBAction(){

    return new Action() {
      @Override
      public void run() throws Throwable {

      }
    };
  }

}
