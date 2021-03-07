package Basics;

// https://www.youtube.com/watch?v=BhZMVuq7GoI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=193

public class ArrayClassDemo {
    public static void main(String[] args){

    // create an array with "Student" class
    Student[] stu = new Student[20];
    System.out.println("stu = " + stu);

    for (int i = 0 ; i < stu.length; i++){
        // give value to the array element
        stu[i] = new Student();

        // give value to the Student class attr
        stu[i].number = (i+1);

        stu[i].state = (int)(Math.random() * (7) );

        stu[i].score = (int)(Math.random() * (100-0+1) );
        }

        // let's print the student data
        for (int i = 0 ; i < stu.length ; i ++){
            // via print command
            //System.out.println("number = " +  stu[i].number + " | " + "state = " + stu[i].state + " | " + "score = " + stu[i].score);
            // or can via method
            System.out.println(stu[i].StudentInfo());
          }
    }
}

class Student {
    int number;
    int state;
    int score;

    // method show student infrm.
    public String StudentInfo(){
        return  "number = " + number + " | " + "state = " + state + " | " + "score = " + score;
    }
}
