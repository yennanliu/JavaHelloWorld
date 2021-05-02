package Basics.Extends_demo1;

// https://www.youtube.com/watch?v=ArTiU9HR5Kw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=259
// https://www.youtube.com/watch?v=UNJC8BrE0Is&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=260

public class ExtendsTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 30;
        System.out.println("p1.age = " + p1.age);
        p1.eat();

        System.out.println("==================");

        Student s1 = new Student();
        s1.age = 20;
        System.out.println("s1.age = " +  s1.age);
        s1.sleep();
        s1.study();

        // getter, setter are OK to call in subclass (child class) as well
        s1.setAge(100);
        System.out.println(s1.getAge());
    }
}
