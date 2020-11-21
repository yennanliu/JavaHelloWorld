package thread;

class MyThread1 extends Thread{
    public MyThread1(String name){
        super(name);
    }

    // re-write run method in Thread
    public void run(){
        int i = 0;
        while (i++ < 10){
            System.out.println(Thread.currentThread().getName() +
            "'s run() method is running");
        }
    }
}

public class ThreadDemo_1 {
    public static void main(String[] args){
        // create the 1st thread (thread1)
        MyThread1 thread1 = new MyThread1("thread1");

        // use start method to start the thread
        thread1.start();

        // create the 2nd thread (thread2)
        MyThread1 thread2 = new MyThread1("thread2");
        thread2.start();
    }
}
