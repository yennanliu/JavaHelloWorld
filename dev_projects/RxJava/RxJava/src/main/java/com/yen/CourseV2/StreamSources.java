package com.yen.CourseV2;

// https://youtu.be/6jjx6OFObBU?si=3-BwifKs9qvaRd2U&t=16

import java.util.stream.Stream;

public class StreamSources {

    private static Stream<String> stringNumbersStrean(){
        return Stream.of("one", "teo", "three");
    }

    private static Stream<Integer> intNumbersStrean(){
        return Stream.iterate(0, i -> i * 2)
                .limit(10);
    }

    private static Stream<User> userStream(){
        return Stream.of(
                new User(1, "aa", "a"),
                new User(2, "bb", "b"),
                new User(3, "cc", "c")
        );
    }

    public static class User{
        private Integer id;
        private String firstName;
        private String lastName;

        public User(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

}
