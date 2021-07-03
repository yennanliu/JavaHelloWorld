package Basics.Block_demo2;

// https://www.youtube.com/watch?v=SvCdVd9que4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=331

class Father {
    // static code block
    static {
        System.out.println("11111111");
    }

    // code block
    {
        System.out.println("2222222222");
    }

    // constructor
    public Father(){
        System.out.println("33333333");
    }
}

public class Son extends Father {
    // static code block
    static {
        System.out.println("44444444");
    }

    // code block
    {
        System.out.println("5555555");
    }

    // constructor
    public Son(){
        System.out.println("66666666");
    }
}


