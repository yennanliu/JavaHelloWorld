package Advances;

// https://www.youtube.com/watch?v=AkNZRvyYivk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=417

/**
 *  Multi-thread
 *
 *  1) Method 1 : Inherit from `thread` class
 *
 *    -> Step 1) create a subclass inherited from `thread` class
 *    -> Step 2) override Thread class' run() -> the operation this thread needs to do
 *    -> Step 3) create instance of (subclass inherited from `thread` class)
 *    -> Step 4) run start() method via subclass above
 */

// example run 1 - 100 even integers
public class ThreadDemo1 {
    public static void main(String[] args) {

        // Step 3) create instance of (subclass inherited from `thread` class)
        MyThread t1 = new MyThread();

        // Step 4) run start() method via subclass above
        t1.start(); // 1st thread

        // 2nd thread
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println("*****main()*****" + i);
            }
        }
    }
}

// Step 1) create a subclass inherited from `thread` class
class MyThread extends Thread {
    // Step 2) override Thread class's run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}