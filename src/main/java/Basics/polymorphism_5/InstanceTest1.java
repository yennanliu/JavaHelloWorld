package Basics.polymorphism_5;

// https://www.youtube.com/watch?v=eD9GJ_Xi9Hg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=289

public class InstanceTest1 {
    // entry point
    public static void main(String[] args){
        // demo1
        InstanceTest1 test = new InstanceTest1();
        // polymorphism: uppercase Student tp Person
        test.method(new Student()); // Note : here we use Student
        test.hey();

        System.out.println("==============");

        // demo2
        // polymorphism: uppercase Graduate tp Person
        test.method(new Graduate());

        System.out.println("==============");

        // demo3
        test.method(new Person());
    }


    public void method(Person e){ // Note : Person here
        String info = e.getInfo();
        System.out.println(info);

        if (e instanceof  Graduate){
            System.out.println("a graduate student");
        } else if (e instanceof  Student){
            System.out.println("a student");
        } else {
            System.out.println("a person");
        }
    }

    public void hey(){
        System.out.println("heyyyyyyyyyyy");
    }
}

class Person{
    // attr
    protected String name = "Person";
    protected int age = 50;
    // method
    public String getInfo(){
        return "Name : " + name + " age : " + age;
    }
}

class Student extends Person{
    // attr
    protected String school = "CMU";
    // method
    @Override
    public String getInfo(){
        return "Name : " + name + " age : " + age + " school : " + school;
    }
}

class Graduate extends Student{
    // attr
    public String major = "CS";
    // method
    @Override
    public String getInfo(){
        return "Name : " + name + " age : " + age + " school : " + school + " major = " + major;
    }
}
