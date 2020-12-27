package thread;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException{
        // create the threads
        Thread thread1 = new Thread(new EmergencyThread(), "thread1");
        thread1.start();
        for (int i = 1; i < 6; i++){
            System.out.println(
                    Thread.currentThread().getName() + " input :" + i
            );
            if (i == 2){
                /*
                 *   NOTICE : "join" will BLOCK THE PROCESS
                 *   THE PROCESS WILL CONTINUE ONLY WHEN THE thread with join completed
                 */
                thread1.join();
            }
        }
    }
}

// implement from Runnable
class EmergencyThread implements Runnable{
    public void run(){
        for (int i = 0; i < 6; i++){
            System.out.println(
                    Thread.currentThread().getName() + " input : " + i);
        }
    }
}