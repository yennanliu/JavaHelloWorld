package Basics;

// https://www.youtube.com/watch?v=Cmc1jNY2DSc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=230

/*
 * CustomerBean is a demo javabean
 */

public class CustomerBean {
    // attr
    private int id;
    private String name;

    // constructor
    public CustomerBean(){
    }

    // getter, setter
    public void setId(int i){
        id = i;
    }

    public int getId(){
        return id;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}
