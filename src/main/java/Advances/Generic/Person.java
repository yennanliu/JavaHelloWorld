package Advances.Generic;

// https://www.youtube.com/watch?v=UhgmcVG05qA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=574

interface Info{
}

class Contact implements Info{
    private String address;
    private String phone;
    private String zipcode;

    public Contact(String address, String phone, String zipcode){
        this.address = address;
        this.phone = phone;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}


class Introduction implements Info{
    private String name;
    private String sex;
    private int age;

    public Introduction(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Person<T extends Info>{
    private T info;

    public Person(T info){
        this.info = info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public T getInfo(){
        return info;
    }

    @Override
    public String toString() {
        return "person info : " + info;
    }
}