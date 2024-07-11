package Basics.EqualsDemo4;

public class test1 {
  public static void main(String[] args) {
    // example 1
    int v1 = 10;
    int v2 = 10;

    System.out.println(v1 == v2); // == compare content (attr, value ....)

    System.out.println("==============");

    // example 2
    String s1 = "abc";
    String s2 = "abc";

    System.out.println(s1 == s2);
    // equals compare actual ADDRESS (in memory)
    System.out.println(s1.equals(s2)); // String already re-write equals

    System.out.println("==============");

    // example 3
    User u1 = new User(1, "nick");
    User u2 = new User(1, "nick");

    System.out.println(u1 == u2); // false
    System.out.println(u1.equals(u2)); // false
  }
}

class User {
  private final int id;
  private final String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
