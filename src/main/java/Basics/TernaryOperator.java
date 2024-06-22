package Basics;

// https://www.youtube.com/watch?v=7Bq7ctG-FX4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=84

public class TernaryOperator {
  public static void main(String[] args) {

    // example 1
    int m = 12;
    int n = 5;

    // if m > n, return m, else return n
    int max = (m > n) ? m : n;
    System.out.println(max);

    System.out.println("--------------");

    // example 2
    double result = (m > n) ? 1 : 0;
    System.out.println(result);

    System.out.println("--------------");

    // example 3
    String max_val = (m > n) ? "m" : "n";
    System.out.println(max_val);

    System.out.println("--------------");

    // example 4
    int n1 = 12;
    int n2 = 20;
    int n3 = -100;
    int max1 = (n1 > n2) ? n1 : n2;
    int max2 = (max1 > n3) ? max1 : n3;
    System.out.println("max num = " + max2);
  }
}
