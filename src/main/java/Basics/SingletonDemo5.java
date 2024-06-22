package Basics;

// https://www.youtube.com/watch?v=QFgDlAis0cM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=339

public class SingletonDemo5 {
  public static void main(String[] args) {
    Bank2 b_1 = Bank2.instance;
    Bank2 b_2 = Bank2.instance;

    System.out.println(b_1 == b_2);

    // wrong : Cannot assign a value to final variable 'instance'
    // Bank2.instance = null;
  }
}

class Bank2 {

  // so we can use final to protect class be changed by user
  // (regular way : use private)
  public static final Bank2 instance = new Bank2();

  private Bank2() {}
}
