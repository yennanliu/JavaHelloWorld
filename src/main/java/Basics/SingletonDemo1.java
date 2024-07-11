package Basics;

// https://www.youtube.com/watch?v=b-UAaq-G4uI&list=PLmOn9nNkQxJEqCNXBu5ozT_26xwvUbHyE&index=91

public class SingletonDemo1 {
  public static void main(String[] args) {
    // run : 餓漢式
    Single s1 = Single.getInstance();
    Single s2 = Single.getInstance();
    System.out.println(s1 == s2);

    System.out.println("----------------");

    // run : static internal method
    Singleton ss1 = Singleton.getInstance();
    Singleton ss2 = Singleton.getInstance();
    System.out.println(ss1.hashCode());
    System.out.println(ss2.hashCode());
  }
}

// Method 1) : 餓漢式
// pros : Thread safety
// cons : could create a class, but not uses it -> resource wasting
class Single {
  private static final Single s = new Single();
    // make constructor private

  public Single() {}

  public static Single getInstance() {
    return s;
  }
}

// Method 2) : 懶漢式
// pros : no resource wasting, only make the instance when need it
// cons : Thread safety concern
class Single2 {
  private static Single2 s = null;

  private Single2() {}

  public static Single2 getInstance() {
    if (s == null) {
      s = new Single2();
    }
    return s;
  }
}

// Method 3) : static internal method
// optimize with above method 1), and 2)
// pros : 1. no resource wasting, only make the instance when need it
// pros : 2. Thread safety (no interruption when running)
class Singleton {
  private Singleton() {}

    // export below static method to public
  public static Singleton getInstance() {
    return SingltonInstance.INSTANCE;
  }

  private static class SingltonInstance { // make it private
    private static final Singleton INSTANCE = new Singleton();
  }
}
