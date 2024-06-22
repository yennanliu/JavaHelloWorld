package Basics.EmployeeCRM.team.service;

// https://www.youtube.com/watch?v=rN0byZHtGw8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=390
// https://www.youtube.com/watch?v=mwg4N3epx9Y&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=502

import javax.print.attribute.standard.MediaSize;

/**
 * class defines employee status
 *
 * <p>NOTE : We can also use `Enum Class` for implementation here ref :
 * https://www.programiz.com/java-programming/enums
 * https://www.twblogs.net/a/5e8ac450bd9eee61ab2feb56
 */

// public class Status {
//    // attr
//    public String NAME;
//
//    // constructor
//    private Status(){
//
//    }
//
//    private Status(String name){
//        this.NAME = name;
//    }
//
//    public static final Status FREE = new Status("FREE");
//    public static final Status BUSY = new Status("BUSY");
//    public static final Status VOCATION = new Status("VOCATION");
//
//    // method
//    public String getNAME(){
//        return NAME;
//    }
//
//    @Override
//    public String toString() {
//        return NAME;
//    }
// }

// update : 20211204, create Enumeration (枚舉類) via enum
public enum Status {
  FREE,
  BUSY,
  VOCATION;
}
