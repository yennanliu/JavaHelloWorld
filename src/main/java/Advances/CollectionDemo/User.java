package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=8Zg6QDXSSAc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=535

import java.util.Objects;

public class User {
    private String name;
    private int age;

    // constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("--> User's equals() ...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
