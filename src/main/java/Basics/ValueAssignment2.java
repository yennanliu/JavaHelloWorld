package Basics;

// https://www.youtube.com/watch?v=vlorUYfBb-8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=229

public class ValueAssignment2 {
    public static void main(String[] args){
        // run
        User_ u = new User_();
        System.out.println(u.age);

        User_  u1 = new User_(10);
        System.out.println(u1.age);

        u1.setAge(7);
        System.out.println(u1.age);
    }
}

class User_{
    // attr
    String name;
    int age =1 ;

    // constructor
    public User_(){
    }

    public User_(int a){
        age = a;
    }

    // getter, setter
    public void setAge(int a){
        age = a;
    }
}

