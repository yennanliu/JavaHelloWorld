package Basics;

// https://pydoing.blogspot.com/2011/05/java-getter-and-setter.html

public class GetterSetterDemo2 {

  public static void main(String[] args) {
    // run
    System.out.println("GetterSetterDemo2 run ...");

    for (int i = 0; i < 20; i++) {
      Encrypt t = new Encrypt();
      System.out.println(t.getcArray());
      System.out.println(t.a);
    }
    System.out.println("GetterSetterDemo2 end ...");
  }

  public static class Encrypt {
    private char[] cArray = new char[26];
    private int a;
    private int b;
    private int n;
    private char c;
    private int diff;

    public Encrypt(int a, int b, int n, char c, int diff) {
      setA(a);
      setB(b);
      setN(n);
      setC(c);
      setDif(diff);
      setArray();
    }

    public Encrypt(int a, int b) {
      this(a, b, 26, 'a', 9999);
    }

    public Encrypt() {
      int ta = 0;
      int tb = 0;

      while (ta % 2 == 0) {
        ta = (int) (Math.random() * 10);
        tb = (int) (Math.random() * 10);
      }
    }

    // getter
    public int getA() {
      return a;
    }

    // setter
    public void setA(int arg) {
      a = arg;
    }

    // getter
    public int getB() {
      return b;
    }

    // setter
    public void setB(int arg) {
      b = arg;
    }

    public int getN() {
      return n;
    }

    public void setN(int arg) {
      n = arg;
    }

    public char getC() {
      return c;
    }

    public void setC(char arg) {
      c = arg;
    }

    public int getDif() {
      return diff;
    }

    public void setDif(int arg) {
      diff = arg;
    }

    public void setArray() {
      int i, d, ci, m;
      char r;
      for (i = 0; i < n; i++) {
        ci = getC();
        d = ci & getA() + getB();
        m = d % getN();
        r = (char) (m + getDif());
        c++;
      }
    }

    public char[] getcArray() {
      return cArray;
    }
  }
}
