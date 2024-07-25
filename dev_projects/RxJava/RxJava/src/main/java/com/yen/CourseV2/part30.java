package com.yen.CourseV2;

// course 30 : Error handling in reactive programming
// https://youtu.be/xzn2KbmkcPE?si=0ijT9sQJnfEpEHq3

import reactor.core.publisher.Flux;

public class part30 {
  public static void main(String[] args) {

     /** Example 1 */
     /**
     *  NOTE !!!
     *
     *   compare below difference (V1, V2, V3)
     *
     *   - err in subscribe
     *   - only subscribe, no err
     *   - doOnError
     *
     */
    ReactiveSources.intNumbersFluxWithException()
          // V1
//        .subscribe(
//                num -> System.out.println(num),
//                err -> System.out.println("error = " + err)

            // V2
//            .subscribe(
//                    num -> System.out.println(num)

           // V3
            .doOnError(err -> System.out.println("error = " + err)) // do sth when error happened, not just receive error
            .subscribe(num -> System.out.println(num)
        );


    /** Example 2
     *
     *  onErrorContinue
     */
    ReactiveSources.intNumbersFluxWithException()
              .onErrorContinue((e, item) -> System.out.println("error !!!" + e.getMessage()))
              .subscribe(num -> System.out.println(num));

    /**
     * Example 3
     *
     * onErrorResume
     */
    ReactiveSources.intNumbersFluxWithException()
        .onErrorResume(err -> Flux.just(-1,-2))
        .subscribe(num -> System.out.println(num));

    // prevent app from exciting
      try {
          Thread.sleep(100000);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }

  }

}
