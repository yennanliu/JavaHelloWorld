package com.yen.dev;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Consumer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

// https://zouzhberk.github.io/rxjava-study/

public class FlowableTest {

  @Test
  public void test1() {
    List<String> list = Arrays.asList("blue", "red", "green", "yellow", "orange", "cyan", "purple");
    Flowable.fromIterable(list).skip(2).subscribe(System.out::println);
    System.out.println("-------");
    Flowable.fromArray(list.toArray()).subscribe(System.out::println);
    System.out.println("-------");
    Flowable.just("blue").subscribe(System.out::println);
  }

  // fromFuture, 事件從非主執行緒產生； fromCallable, 事件從主執行緒產生， 在需要消費時生產；
  @Test
  public void test2() {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    System.out.println("MAIN: " + Thread.currentThread().getId());
    Callable<String> callable = () -> {
      System.out.println("callable [" + Thread.currentThread().getId() + "]: ");
      Path filePath = Paths.get("build.gradle");
      return Files.readAllLines(filePath).stream().flatMap(s -> Arrays.stream(s.split
              (""))).count() + "";
    };

    Future<String> future = executor.submit(callable);

    Consumer<String> onNext = v -> System.out
            .println("consumer[" + Thread.currentThread().getId() + "]:" + v);

    Flowable.fromCallable(callable).subscribe(onNext);
    Flowable.fromFuture(future).subscribe(onNext);
    System.out.println("END");
  }

}
