package com.yen.CourseV2;

// course 21 : Handling unresponsive Monos with timeout
// https://youtu.be/uOfTSkDy-mk?si=AajRiSx-VwdRArIn

import java.io.IOException;
import java.time.Duration;

public class part21 {
  public static void main(String[] args) throws IOException {

    // Exception in thread "main" java.lang.IllegalStateException: Timeout on blocking read for
    // 5000000000 NANOSECONDS
    ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

    System.out.println("press a key to end");
    System.in.read();
  }
}
