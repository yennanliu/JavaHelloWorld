package Basics;

// https://www.youtube.com/watch?v=hJXPcZa698A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=189

public class ClassDemo2 {
  public static void main(String[] args) {
    // run
    Person_ p1 = new Person_();

    p1.name = "jerrry";
    p1.age = 17;
    p1.sex = 0;

    p1.study();
    p1.showAge();
    p1.addAge(100);

    System.out.println(p1.age);

    System.out.println("===============");

    Person_ p2 = new Person_();

    p2.showAge();
    p2.addAge(10);
    p2.showAge();
  }
}
