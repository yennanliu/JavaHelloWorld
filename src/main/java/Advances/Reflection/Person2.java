package Advances.Reflection;

// https://www.youtube.com/watch?v=x6tmNMxMmZo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=648
// https://www.youtube.com/watch?v=Y2vkfcQZ8Es&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=655

// @MyAnnotation(value = "hi")
@MyAnnotation()
public class Person2 extends Creature<String> implements Comparable<String>, MyInterface {

  public int id;
  int age;
  private String name;

  public Person2() {}

  private Person2(String name) {
    this.name = name;
  }

  public Person2(String name, int age) {
    this.name = name;
    this.age = age;
  }

  private static void showDest() {
    System.out.println(">>> showDest");
  }

  @Override
  public int compareTo(String o) {
    return 0;
  }

  @MyAnnotation(value = "abc")
  @Override
  public void info() {
    System.out.println(">>> I am a person2 ...");
  }

  private String show(String msg) {

    System.out.println(">>> person2 show ..." + msg);
    return msg;
  }

  public String display(String input) throws NullPointerException, ClassCastException {
    return ">>> person2 input = " + input;
  }
}
