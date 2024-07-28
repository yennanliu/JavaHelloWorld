package com.yen.CourseV2;

import java.io.IOException;

// course 31 : flux -> mono
// https://youtu.be/xrpqIYC-asc?si=2rKYXbcN9Bi6tWKM
public class part31 {
  public static void main(String[] args) throws IOException {

    /** example 1 */
    ReactiveSources
            .intNumbersFlux()
            .count()
            .subscribe(x -> System.out.println(x));

    /** example 2 */
    ReactiveSources
            .intNumbersFlux()
            .collectList()
            .subscribe(x -> System.out.println("--->" + x));

    /** example 3 */
    ReactiveSources
            .intNumbersFlux()
            .buffer(2)
            .map(list -> list.get(0) + list.get(1))
            .subscribe(x -> System.out.println("====>" + x));

    System.out.println("press a key to end");
    System.in.read();

  }

}
