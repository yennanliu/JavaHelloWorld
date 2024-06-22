package Basics;

// https://www.youtube.com/watch?v=7Scpb0YKtjA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=315

public class staticDemo3 {
  public static void main(String[] args) {

    Japanese j1 = new Japanese();
    j1.name = "yoshi";
    j1.age = 19;
    j1.nation = "JP";

    Japanese j2 = new Japanese();
    j2.name = "Lynn";
    j2.age = 30;

    // nation is static attr
    // so there is ONLY ONE such value in the "static area"
    // and j1 already define nation
    System.out.println("j2.nation = " + j2.nation);

    j2.nation = "Japan";

    System.out.println("j1.nation = " + j1.nation);

    // and we can call the static method directly
    System.out.println(Japanese.nation);
  }
}

class Japanese {
  static String nation; // static attr
  // attr
  String name;
  int age;
}
