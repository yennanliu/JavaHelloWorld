package Basics.Extends_demo2;

// https://www.youtube.com/watch?v=i4HGpPEWN2k&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=266

public class KidTest {
    public static void main(String[] args){

        // run
        Kids someKid = new Kids(12);

        someKid.getYearsOld();

        someKid.printAge();

        // use method from superclass
        someKid.setSalary(0);
        someKid.setSex(0);

        // use method from superclass
        someKid.employed();
        someKid.manOrWoman();
    }
}
