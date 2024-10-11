package com.yen.dev;

import io.reactivex.rxjava3.core.Single;
import java.util.List;

public class AnyMatchTest {

  public static void main(String[] args) {

    // Example: Single containing an ImmutableList of className elements
    Single<List<className>> singleList =
        Single.just(
                List.of(
                new className("Element1"), new className("Element2"), new className("Element3")));

    // Value to check for
    String elementToCheck1 = "Element1";
    String elementToCheck2 = "Element4";

    // Check if Element1 exists
    checkIfElementExists(singleList, elementToCheck1);

    // Check if Element4 exists
    checkIfElementExists(singleList, elementToCheck2);
  }

  // Method to check if a specific element exists in the list using anyMatch
  private static void checkIfElementExists(
      Single<List<className>> singleList, String valueToCheck) {
    singleList
        .map(
            list ->
                list.stream()
                    .anyMatch(
                        element ->
                            element.getName().equals(valueToCheck))) // Check if any element matches
        .subscribe(
            result -> {
              System.out.println("Does the element \"" + valueToCheck + "\" exist? " + result);
            },
            throwable -> {
              System.err.println("Error: " + throwable);
            });
  }
}

class className {
    String name;

    public className(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}