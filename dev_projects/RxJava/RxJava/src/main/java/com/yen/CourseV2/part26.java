package com.yen.CourseV2;

// course 26 : The log operator
// https://youtu.be/a64YcYhSxZs?si=_G7OIwIMt-v000a9

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class part26 {
  public static void main(String[] args) throws IOException {

    // example 1
    List<Integer> numbers =
        ReactiveSources.intNumbersFlux()
            .log() // NOTE !!! add log within processing
            .toStream()
            .collect(Collectors.toList());

    /**
     * Log is as below
     *
     * <p>/Users/yennanliu/Library/Java/JavaVirtualMachines/corretto-11.0.16/Contents/Home/bin/java
     * -javaagent:/Applications/IntelliJ IDEA
     * CE.app/Contents/lib/idea_rt.jar=49767:/Applications/IntelliJ IDEA CE.app/Contents/bin
     * -Dfile.encoding=UTF-8 -classpath
     * /Users/yennanliu/JavaHelloWorld/dev_projects/RxJava/RxJava/target/classes:/Users/yennanliu/.m2/repository/com/netflix/rxjava/rxjava-core/0.20.7/rxjava-core-0.20.7.jar:/Users/yennanliu/.m2/repository/io/reactivex/rxjava3/rxjava/3.1.6/rxjava-3.1.6.jar:/Users/yennanliu/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/Users/yennanliu/.m2/repository/io/projectreactor/reactor-core/3.6.5/reactor-core-3.6.5.jar
     * com.yen.CourseV2.part26 [ INFO] (main)
     * onSubscribe(FluxConcatMapNoPrefetch.FluxConcatMapNoPrefetchSubscriber) [ INFO] (main)
     * request(256) [ INFO] (parallel-1) onNext(1) [ INFO] (parallel-2) onNext(2) [ INFO]
     * (parallel-3) onNext(3) [ INFO] (parallel-4) onNext(4) [ INFO] (parallel-5) onNext(5) [ INFO]
     * (parallel-6) onNext(6) [ INFO] (parallel-7) onNext(7) [ INFO] (parallel-8) onNext(8) [ INFO]
     * (parallel-1) onNext(9) [ INFO] (parallel-2) onNext(10) [ INFO] (parallel-2) onComplete() List
     * is = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] List size = 10
     *
     * <p>Process finished with exit code 0
     */
    System.out.println("List is  = " + numbers);
    System.out.println("List size = " + numbers.size());

    // example 2
    ReactiveSources.intNumbersFlux()
        // .log() // NOTE !!! can add log at different step in op
        .filter(e -> e > 5)
        .log() // NOTE !!! add log within processing
        .subscribe(System.out::println);

    System.out.println("press a key to end");
    System.in.read();
  }
}
