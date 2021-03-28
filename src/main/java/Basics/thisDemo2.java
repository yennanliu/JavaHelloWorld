package Basics;

// https://www.youtube.com/watch?v=Pmqp7R-J3ys&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=232

public class thisDemo2 {
    public static void main(String args[]){
        // run
        Person_4 p1 = new Person_4();
        p1.setAge(100);
        System.out.println(p1.getAge());
        p1.setName("tommy");
        System.out.println(p1.getName());
    }
}

class Person_4 {
    // attr
    private String name;
    private int age;

    // getter, setter
    public void setName(String name){
        //name = name;  //<-- this one NOT working, since it try to dispense the value  to itself (name)
        this.name = name;  // this means the "current" class, so this.name means current class's name
    }

    public String getName(){
        return name;
    }

    public void setAge(int age) {
        //age = age;  //<-- this one NOT working, since it try to dispense the value  to itself (age)
        this.age = age;  // this means the "current" class
    }

    public int getAge() {
        return age;
    }
}
