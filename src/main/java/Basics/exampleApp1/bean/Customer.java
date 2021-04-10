package Basics.exampleApp1.bean;

// https://www.youtube.com/watch?v=c2d0vVbvoSQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=248
// https://www.youtube.com/watch?v=eYPhf4f0B8g&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=249

/*
 *   Customer instance class
 *    -> for Customer inform. encapsulation
 */

public class Customer {
    // attr
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    // constructor
    public Customer(){
    }

    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
