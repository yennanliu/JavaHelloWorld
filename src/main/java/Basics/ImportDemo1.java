package Basics;


import java.util.Arrays;

// https://www.youtube.com/watch?v=0ErGo2Dj7lM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=239

/*
 *  Import
 *  1) use "import" to import class, interface in current code
 *  2) put "import" between package declaration and class declaration
 *  3) if need multiple imports
 *       -> import them line by line
 *  4) if multiple imports under same package
 *       -> import.*
 *  5) NO NEED TO IMPORT Java core lib (java.lib), they are imported by default
 *  6) NO NEED TO IMPORT if the class/interface is IN THE SAME PACKAGE
 *  7) if want to use multiple class/interface WITH SAME NAME from different packages
 *       -> use them by package.class (whole name) directly
 *  8) NEED TO IMPORT if want to use class/interface in the sub package (children package) of current package
 *  9) import Static : import static attr/method in current class
 *       -> example : System.out.println
 */

public class ImportDemo1 {
    public static void main(String[] args){
        // run
        String info = Arrays.toString(new int[] {1,2,3});

        System.out.println("info = " + info);

        // use class/interface with same name but from different package
        Basics.thisDemo5.Account acc1 = new Basics.thisDemo5.Account(1000);

        Basics.thisDemo3.Account acc2 = new Basics.thisDemo3.Account(1, 100, 0.1);
    }
}
