package Basics.ExceptionDemo6;

// https://www.youtube.com/watch?v=JBGh4Lb9Fns&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=380

public class StudentTest {
  public static void main(String[] args) {
    // run
    Student s = new Student();
    s.register(777);
    System.out.println(s);

    System.out.println("===============");

    try {
      Student s2 = new Student();
      s2.register(-100);
      System.out.println(s2);
    } catch (Exception e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}

class Student {

  private int id;

  public void register(int id) {
    if (id > 0) {
      this.id = id;
    } else {
      // System.out.println("invalid id !");
      // manually throws exception
      // NOTE : no need to have `throws Exception` outside of the func
      throw new RuntimeException("invalid id !");
    }
  }

  public void register2(int id) throws Exception {
    if (id > 0) {
      this.id = id;
    } else {
      // NOTE : if ` throw new Exception`,
      // then we need `throws Exception` outside of the func
      throw new Exception("invalid id !");
    }
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + '}';
  }
}
