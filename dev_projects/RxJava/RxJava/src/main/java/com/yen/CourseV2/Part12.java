package com.yen.CourseV2;

// course 12
// https://youtu.be/6jjx6OFObBU?si=cm5iPsdPfPMZqvd5&t=12

import java.io.IOException;

public class Part12 {
  public static void main(String[] args) throws IOException {

    // when a new event generated, do something (print it out)
    ReactiveSources.intNumbersFlux().subscribe(x -> System.out.println(x));

    ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

    System.out.println("press a key to end");
    System.in.read();

  }

}
