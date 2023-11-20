package DesignPattern.Singleton;

/** Singleton Demo 1 **/

// https://www.runoob.com/design-pattern/singleton-pattern.html

class MyClass{

    // attr
    private static MyClass instance = new MyClass();

    // constructor
    // below is WRONG
//    private MyClass(){
//        //return MyClass;
//        this.instance = new MyClass();
//    }

    // NOTE !!! we ONLY make no arg constructor, that's it.
    //          so class CAN'T be init by other class
    //          the only way to get class instance
    //          is via getInstance() method, and make sure
    //          there is ALWAYS 1 instance
    private MyClass(){

    }

    public static MyClass getInstance(){
        if (instance != null){
            return instance;
        }
        return new MyClass();
    }

}

public class demo1 {

    public static void main(String[] args) {

        MyClass myClass1 = MyClass.getInstance();
        MyClass myClass2 = MyClass.getInstance();
        System.out.println(myClass1 == myClass2); // true
    }

}
