package Basics;

// https://www.youtube.com/watch?v=hNHutM_k7EM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=354

public class ProxyDemo2 {
    public static void main(String[] args) {
        // run
        // NOT expose RealStar to external
        Star s = new Agent(new RealStar());
        s.confer();
        s.singContract();
        s.bookTicket();
        s.sing();  // this method is from RealStar
        s.collectMoney();
    }
}

interface Star {
    // attr

    // method
    void confer();

    void singContract();

    void bookTicket();

    void sing();

    void collectMoney();
}

/** proxied class */
class RealStar implements Star {

    @Override
    public void confer() {

    }

    @Override
    public void singContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void sing() {
        System.out.println("Real star sing !!!!");
    }

    @Override
    public void collectMoney() {

    }
}

/** proxy class */
class Agent implements Star {
    // attr
    private Star real;

    // constructor
    public Agent(Star real){
        this.real = real;
    }

    // method
    @Override
    public void confer() {
        System.out.println("agent confer");
    }

    @Override
    public void singContract() {
        System.out.println("agent singContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("agent bookTicket");
    }

    @Override
    public void sing() {
       /**
        * --------------------------------------------------
        * NOTE : we need to use real star's sing method here
        * --------------------------------------------------
        */
       real.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("agent collectMoney");
    }
}
