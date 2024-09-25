package com.yen.Util;

// import rx.Observable;

import io.reactivex.rxjava3.core.Observable;

public class GroceryUtil {

  Observable<Integer> purchase(String prodName, int quantity) {
    return Observable.fromCallable(() -> doPurchase(prodName, quantity));
  }

  Integer doPurchase(String prodName, int quantity) {
    System.out.println("prodname = " + prodName + ", quantity = " + quantity);
    // some logic
    return quantity;
  }

}
