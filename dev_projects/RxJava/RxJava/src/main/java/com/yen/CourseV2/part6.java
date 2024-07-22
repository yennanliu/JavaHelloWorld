package com.yen.CourseV2;

// course 6
// https://youtu.be/3mTwLtmtlqg?si=e2prqUUdl807mr4L

import java.util.stream.Stream;

public class part6 {
  public static void main(String[] args) {

  }

  private static Stream<String> stringNumbersStrean(){
      return Stream.of("one", "teo", "three");
  }

  private static Stream<Integer> intNumbersStrean(){
      return Stream.iterate(0, i -> i * 2)
              .limit(10);
  }

  private static Stream<User> userStream(){
      return Stream.of(
              new User(1, "aa"),
              new User(2, "bb")
      );
  }

  private static class User{
      private Integer id;
      private String name;

      public User(int id, String name) {
          this.id = id;
          this.name = name;
      }
  }

}
