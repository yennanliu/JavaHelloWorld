package Basics;

// https://www.youtube.com/watch?v=fk7MlDcWqPM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=347

/**
 * Design pattern : Template
 */

public class TemplateDemo2 {
    public static void main(String[] args) {
        // run

        // polymorphism
        BankTemplateMethod btm = new DrawMoney();
        /** call process, but call overwrite methods inside (Template method) */
        btm.process();

        System.out.println("===============");

        // polymorphism
        BankTemplateMethod btm2 = new ManageMoney();
        btm2.process();
    }
}


abstract class BankTemplateMethod{
    // method
    public void takeNumber(){
        System.out.println("take number and wait in queue");
    }

    // use abstract method if this method is different in different use cases
    public abstract void transact();

    public void evaluate(){
        System.out.println("send feedback");
    }

    /** Template method : put basics op together, can not overwrite by subclass */
    public final void process(){

        this.takeNumber();

        this.transact(); // will run different implemented method in different sub class

        this.evaluate();
    }
}

class DrawMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("i want to withdraw !!!");
    }
}

class ManageMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("i want a finance assistance! here is 2000 USD");
    }
}