package Workspace.project1;

class MyClass{

     void myPrint(int width){
        if (width % 2 == 0){
            System.out.println("width should be odd");
            return;
        }
        String star = "*";
        for (int i = width; i >= 0; i-=2){
            System.out.println(star.repeat(i));
        }
         for (int i = 3; i <= width; i+=2){
             System.out.println(star.repeat(i));
         }

    }
}

public class myPrint {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        int width  = 5;
        //int width  = 7;
        myClass.myPrint(width);
    }

}
