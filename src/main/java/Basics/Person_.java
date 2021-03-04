package Basics;

public class Person_ {
    String name;
    int age;
    /** sex = 1 -> male, sex = 0 -> female */
    int sex;

    public void study(){
        System.out.println("study ...");
    }

    public void showAge(){
        System.out.println("age =  " + age);
    }

    public int addAge(int i){
        age += i;
        return age;
    }
}
