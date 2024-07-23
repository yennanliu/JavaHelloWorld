package com.yen.CourseV2;

// course 14
// https://youtu.be/QIqE3Nzfkfc?si=9d5snnce5GS40FdN

import java.util.List;
import java.util.stream.Collectors;

public class part14 {
  public static void main(String[] args) {

      // flux -> list
      List<Integer> numbers =  ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());
      // NOTE !!! below print may take some time (blocking operation)
      System.out.println("list  = " + numbers);
      System.out.println("list size = " + numbers.size());
  }

}
