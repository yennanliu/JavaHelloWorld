package Basics.interfaceDemo5;

// https://www.youtube.com/watch?v=LfIyZ-iAJyE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=357

public class test {
    public static void main(String[] args) {
        // run

        CompareCircle c1 = new CompareCircle(3.4);
        CompareCircle c2 = new CompareCircle(3.6);

        int compareValue1 = c1.compareTo(c2);
        if (compareValue1 > 0){
            System.out.println("c1 is larger");
        } else if (compareValue1 < 0){
            System.out.println("c2 is larger");
        } else {
            System.out.println("c1 and c2 are equal");
        }

        System.out.println("==================");
    }
}
