package Basics;

// https://www.youtube.com/watch?v=fk7MlDcWqPM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=347

/**
 * Design pattern : Template
 *
 *  1) abstract class' application
 *  2)
 */

public class TemplateDemo1 {
    public static void main(String[] args) {
        // run

        // Polymorphism
        Template t = new subTemplate();

        // or below is OK as well
        //subTemplate t = new subTemplate();

        t.spendTime();
    }
}

/** Design pattern : Template */
abstract class Template {
    // get time cost for a piece of code
    /** Template method : put basics op together, can not overwrite by subclass */
    public void spendTime() {

        long start = System.currentTimeMillis();

        /** Not defined part, could be dynamic */
        this.code();

        long end = System.currentTimeMillis();

        System.out.println("spend time = " + (end - start));
    }

    public abstract void code();
}

class subTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }

}