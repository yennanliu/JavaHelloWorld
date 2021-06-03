package Basics.objectDemo1;

// https://www.youtube.com/watch?v=KITuqq2JSDM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=293

public class GCdemo1 {
    public static void main(String[] args){
        // run
        User u1 = new User("001", 19);

        System.out.println(u1.toString());

        System.out.println(u1);

        /** garbage collect (GC) */

        // make instance as garbage object (as null), so the instance will be awaiting for gc (garbage collect)
        // but we are not sure when the gc happen
        u1 = null;

        // so here we force gc run
        // will call the finalize method BEFORE gc
        System.gc();
    }
}


class User {
    // attr
    String id;
    Integer age;

    // constructor
    public User(String id, Integer age){
        this.id = id;
        this.age = age;
    }

    // getter, setter
    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // method
    // Override finalize from java.lang.Object
    @Override
    protected void finalize() throws Throwable { // Overrides deprecated method in 'java.lang.Object
        System.out.println("object is going to be released ---> " + this);
    }

    // Override toString from java.lang.Object
    @Override
    public String toString(){
        return "id = " + this.id + " age = " + this.age;
    }
}

