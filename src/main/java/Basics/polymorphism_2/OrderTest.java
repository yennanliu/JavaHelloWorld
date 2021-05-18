package Basics.polymorphism_2;

// https://www.youtube.com/watch?v=-dlhK0u7d2I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=280

import java.sql.Connection;

public class OrderTest{
}

class Order {
    // example 1
    public void method(Object obj){ // can use any subclass of Object with polymorphism feature

    }
}

class Driver{
    // example 2
    public void getData(Connection conn){ // Connection is the superclass (interface), but when runtime, it my use different conn (subclass), e.g. : mysqlConn, postgreConn...
        //conn.method1();
        //conn.method2();
        // ....
    }
}
