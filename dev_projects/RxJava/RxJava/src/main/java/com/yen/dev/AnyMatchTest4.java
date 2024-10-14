package com.yen.dev;

import java.util.Arrays;
import java.util.List;

public class AnyMatchTest4 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "orange");

        // Case 1: No matches
        boolean hasMatch1 = items.stream().anyMatch(item -> item.equals("grape"));
        System.out.println("Has match (grape): " + hasMatch1); // Output: false

        // Case 2: Empty list
        List<String> emptyList = Arrays.asList();
        boolean hasMatch2 = emptyList.stream().anyMatch(item -> item.equals("grape"));
        System.out.println("Has match (empty list): " + hasMatch2); // Output: false

        // Case 3: One match
        boolean hasMatch3 = items.stream().anyMatch(item -> item.equals("banana"));
        System.out.println("Has match (banana): " + hasMatch3); // Output: true
    }
}