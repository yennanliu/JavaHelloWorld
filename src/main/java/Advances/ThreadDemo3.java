package Advances;

// https://www.youtube.com/watch?v=3Fh9wzdk16Y&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=419

/**
 *   Create 2 tread
 *
 *   1) 1st thread : even nums in 0-100
 *   2) 2nd thread : odd nums in 0-100
 *
 *   Use 2 ways run the thread
 *
 *   1) formal way, make instance, then use its start() method
 *   2) via anonymous subclass
 */


public class ThreadDemo3 {
    public static void main(String[] args) {

        // run

        /**
         * V1 : formal way, make instance, then use its start() method
         */
//        MyThread3_1 t1 = new MyThread3_1();
//        MyThread3_2 t2 = new MyThread3_2();
//
//        t1.start();
//        t2.start();

        /**
         * V2 : via anonymous subclass
         */

        new MyThread3_1(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i ++){
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " : "+ i);
                    }
                }
            }
        }.start();

        new MyThread3_2(){
            @Override
            public void run() {
               for (int i = 0; i < 100; i ++){
                   if (i % 2 == 1){
                       System.out.println(Thread.currentThread().getName() + " : "+ i);
                   }
               }
            }
         }.start();
    }
}


class MyThread3_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : "+ i);
            }
        }
    }
}

class MyThread3_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i ++){
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + " : "+ i);
            }
        }
    }
}
