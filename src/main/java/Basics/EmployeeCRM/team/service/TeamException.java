package Basics.EmployeeCRM.team.service;

// https://www.youtube.com/watch?v=NIDV6Ol1QLw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=392

/** user defined exception */
public class TeamException extends Exception{
    // attr
    static final long serialVersionUID = -335430000124229948L;

    // constructor
    public TeamException(){
        super();
    }

    public TeamException(String msg){
        super(msg);
    }
}
