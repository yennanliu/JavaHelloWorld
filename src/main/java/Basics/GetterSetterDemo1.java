package Basics;

// https://dotblogs.com.tw/law1009/2012/01/06/64665

public class GetterSetterDemo1 {
  // private variable
  private String hello = "";

  public static void main(String[] args) {
    // run
    GetterSetterDemo1 hello = new GetterSetterDemo1();
    // run getter -> set up instance attribution
    hello.setHello("yaaaaa helo helo");
    // run setter -> get instance attribution
    System.out.println("output = " + hello.getHello());

    // run 2
    GetterSetterDemo1 hello2 = new GetterSetterDemo1();
    hello2.setHello("");
    System.out.println("output = " + hello2.getHello());
  }

  // getter
  public String getHello() {
    return this.hello;
  }

  // setter
  public void setHello(String val) {
    if (val != "") {
      // prevent empty val
      this.hello = val;
    }
  }
}
