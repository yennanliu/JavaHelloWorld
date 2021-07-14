package Basics.interfaceDemo6;

// https://www.youtube.com/watch?v=tiwGXRJcPIY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=358

public class test {
    public static void main(String[] args) {
        // run
        SubClass s = new SubClass();

        // demo 1
        // *** NOTE :
        // static method in interface CAN ONLY used by interface itself
        //s.method1();      // this one is wrong
        CompareA.method1(); // this one is OK

        // demo 2
        // class that implements interface, can use default methods in interface
        // if class override the method, then will used overridden method
        s.method2();
        s.method3();

        System.out.println("================");

        // demo 3
        SubClass2 s2 = new SubClass2();
        // if subclass implements the same methods (same param as well ) as the one in superclass
        // -> and if subclass DOESN'T override the method
        // -> then in default, in subclass we will use the method DEFINED IN SUPERCLASS
        s2.method3();

        System.out.println("================");

        // demo 4
        SubClass3 s3 = new SubClass3();
        s3.method3();

        // demo 5
        System.out.println("================");
        s3.myMethod();
    }

}


class SubClass implements CompareA {
    @Override
    public void method2(){
        System.out.println("Compare A : LONDON");
    }
}


class SubClass2 extends SuperClass implements CompareA {
    @Override
    public void method2(){
        System.out.println("Compare A : LONDON");
    }
}

// if NOT override method3 -> wrong : Basics.interfaceDemo6.SubClass3 inherits unrelated defaults for method3() from types Basics.interfaceDemo6.CompareA and Basics.interfaceDemo6.CompareB
class SubClass3 extends SuperClass implements CompareA, CompareB {
    @Override
    public void method2(){
        System.out.println("Compare A : LONDON");
    }

    @Override
    public void method3() {
        System.out.println("SubClass3 : Riga");
    }

    /**
     * How to use methods which are overridden from superclass, interface in subclass
     */
    public void myMethod(){
        // use subclass' method 3
        method3();
        // use superclass' method 3
        super.method3();

        // *** use interface's default method
        CompareA.super.method3();
        CompareB.super.method3();
    }
}