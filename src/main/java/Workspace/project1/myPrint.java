package Workspace.project1;

class MyClass {

  void myPrint(int width) {
    if (width % 2 == 0) {
      System.out.println("width should be odd");
      return;
    }
    String star = "*";
    String space = " ";

    int j = 0;
    for (int i = width; i >= 0; i -= 2) {
      System.out.println(space.repeat(j) + star.repeat(i));
      j += 1;
    }

    j -= 2;
    for (int i = 3; i <= width; i += 2) {
      System.out.println(space.repeat(j) + star.repeat(i));
      j -= 1;
    }
  }
}

public class myPrint {
  public static void main(String[] args) {

    MyClass myClass = new MyClass();
    // int width  = 5;
    // int width  = 7;
    int width = 9;
    myClass.myPrint(width);
  }
}
