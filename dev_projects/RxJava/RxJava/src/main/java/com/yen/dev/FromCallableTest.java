package com.yen.dev;

import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FromCallableTest {

  @Test
  public void test1() {
    List<Integer> myList = new ArrayList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);
    // Single.fromCallable(myList);
  }
}
