package Advances.ThreadCommunication2;

// https://www.youtube.com/watch?v=97HVF6GT0AI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=441

import java.util.concurrent.ThreadPoolExecutor;

/**
 *  Thread Communication example 2 :  producer-consumer question
 *
 *  - 1) Producer send the product to clerk, and consumer will take the products,
 *    the clerks can only maintain fixed amount of the product (e.g. 20). Producers
 *    need to wait till there is a space for storage before creating more products.
 *    Consumers need to wait till there is available products
 *
 *
 *  - 2) Analysis:
 *      - multi thread ? -> yes, consumer multi thread, producer multi threads
 *      - thread safety ? -> yes, there is shared values
 *                           - clerk
 *                           - product, product amount..
 *      - how to solve thread safety ? -> synchronized methods, we have 2 ways
 *                                      - synchronized code block
 *                                      - synchronized method
 *                                      - lock
 *
 *      - thready communication ? -> yes
 *
 *  - 3) There are 2 cases we need to solve:
 *     - Producer is faster than consumer : consumer may miss some product (data)
 *     - Producer is slower than consumer : some consumers make take the same product (data)
 *
 */

// entry point
public class ProductTest {
    public static void main(String[] args) {

        // run
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("Producer-1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("Consumer-1");

        p1.start();
        c1.start();
    }
}

/** clerk */
class Clerk{

    // attr
    private int productCount = 0;

    // method
    // produce product
    public void produceProduct() {
        if (productCount < 20){
            productCount += 1;
            System.out.println(Thread.currentThread().getName()+ " starts producing " + productCount + " product ...");
        }else{
            //System.out.println("meet max product count");
            //wait();
        }
    }

    // consume product
    public void consumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName()+ " starts consuming " + productCount + " product ...");
            productCount -= 1;
        }else{
            //wait();
        }
    }
}

/** producer */
class Producer extends Thread{

    // attr
    private Clerk clerk;

    // constructor
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    // method
    @Override
    public void run() {
        
        super.run();
        System.out.println(this.getName() + "Producer produces product ...");

        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

/** consumer */
class Consumer extends Thread {

    // attr
    private Clerk clerk;

    // constructor
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    // method
    @Override
    public void run() {

        super.run();
        System.out.println(this.getName() + "Consumer consumes product ...");

        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}
