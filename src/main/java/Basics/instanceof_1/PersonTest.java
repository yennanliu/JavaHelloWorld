package Basics.instanceof_1;

// https://www.youtube.com/watch?v=kQtKcNX4O44&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=287
// ref : Basics.polymorphism_1

public class PersonTest {
    public static void main(String[] args){

        System.out.println("============================");

        Person p2 = new Man();
        p2.name = "ken";
        Man m2 = (Man) p2; // DownCasting
        m2.makeMoney();
        m2.isSmoking = true;

        // when use DownCasting, we may face "ClassCastException" exception (as below)
        // so it's good to use isClassOf verify it before run
        //Woman w1 = (Woman) p2;
        //w1.goShopping();

        System.out.println("============================");

        /**
         *   instanceof:
         *
         *   1) a instanceof A : check if a is instance of A, if yes, return True, else False
         *   2) using case :
         *      -> to prevent the "ClassCastException" exception, we use instanceof
         *         before we do DownCasting. (if return true, then do DownCasting, else do nothing)
         *   3) if a instanceof A return true, and a instanceof B return true
         *      -> B is A's superclass
         */
        if (p2 instanceof Woman) {
            Woman w1 = (Woman) p2;
            w1.goShopping();
            System.out.println("==========  woman  ========== ");
        }

        System.out.println("============================");

        if (p2 instanceof Man) {
            Man m3 = (Man) p2;
            m3.makeMoney();
            System.out.println("==========  Man  ========== ");
        }

        System.out.println("============================");


        if (p2 instanceof Person) {
            System.out.println("==========  Person  ========== ");
        }

        System.out.println("============================");

        if (p2 instanceof Object) {
            System.out.println("==========  Object  ========== ");
        }

    }
}
