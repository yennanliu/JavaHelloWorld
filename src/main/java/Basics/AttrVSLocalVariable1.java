package Basics;

// https://www.youtube.com/watch?v=fJbMy7QqhEE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=183

public class AttrVSLocalVariable1 {
  public static void main(String[] args) {

    // run

    /* NOTE :
     *
     *  1) private, public, protected -> Encapsulation (OOP)
     *  2) Default value:
     *      - class attribution (non-static)
     *          - byte, short, int, long : 0
     *          - float, double : 0.0
     *          - char : 0 (or '\u0000')
     *          - boolean : false
     *     - local variable
     *          - THERE IS NO DEFAULT VALUE
     *          - => we need to declare the values explicitly
     *          - however, if is "func local variable" case, we can declare the value until use it
     *  3) in-memory space
     *      - class attribution  (non-static) : Heap
     *      - local variable : Stack
     */
    User2 u1 = new User2();
    System.out.println(u1.name);
    System.out.println(u1.age);
    System.out.println(u1.isMale);

    u1.talk("English");
    u1.eat();
  }
}

class User2 {
  public int age;
  // class attribution
  String name;
  boolean isMale;

  public void talk(String language) { // language is a func local variable
    System.out.println("we're using " + language);
  }

  public void eat() {
    String food = "tofu"; // local variable
    System.out.println("people eat " + food);
  }
}
