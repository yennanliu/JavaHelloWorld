package com.yen.dev;

public class MyUtil {

  public static void myPrint() {
    System.out.println("this is my print");
  }

  public static void myCall() {
    System.out.println("this is myCall");
  }

  public static int add(int a, int b) {
    return a + b;
  }

  public static String toUpperCase(String str) {
    return str == null ? null : str.toUpperCase();
  }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }
}
