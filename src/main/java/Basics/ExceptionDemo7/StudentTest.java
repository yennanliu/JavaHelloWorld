package Basics.ExceptionDemo7;

// https://www.youtube.com/watch?v=JBGh4Lb9Fns&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=380
// https://www.youtube.com/watch?v=TJuq8kZiN9U&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=381

public class StudentTest {
    public static void main(String[] args) {
        // run
        Student s = new Student();
        s.register(777);
        System.out.println(s);

        System.out.println("===============");

        try {
            Student s2 = new Student();
            s2.register(-100);
            System.out.println(s2);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student{

    private int id;

    public void register(int id){
        if (id > 0){
            this.id = id;
        } else{
            // manually throws exception
            // NOTE : no need to have `throws Exception` outside of the func
            //throw new RuntimeException("invalid id !");
            throw new MyException("CAN'T INSERT MINUS NUMBER ID !");
        }
    }
}
