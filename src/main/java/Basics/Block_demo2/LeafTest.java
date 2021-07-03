package Basics.Block_demo2;

// https://www.youtube.com/watch?v=SvCdVd9que4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=331

// run
public class LeafTest{
    public static void main(String[] args) {
        // run
        new Leaf();

    }
}

class Root{
    static {
        System.out.println("Root's static code block");
    }

    {
        System.out.println("Root's code block");
    }

    // constructor
    public Root(){
        System.out.println("Root 's non param constructor");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid's static code block");
    }

    {
        System.out.println("Mid's code block");
    }

    // constructor
    public Mid(){
        System.out.println("Mid 's non param constructor");
    }

    public Mid(String msg){
        // via this() to reload the non param constructor
        this();
        System.out.println("Mid 's param constructor");
        System.out.println("msg = " + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("LeafTest's static code block");
    }

    {
        System.out.println("LeafTest's code block");
    }

    // constructor
    public Leaf(){
        // via super to call param constructor in SUPER CLASS
        super("UCLA");
        System.out.println("LeafTest 's non param constructor");
    }
}
