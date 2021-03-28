## Main project
- [utility_Java](https://github.com/yennanliu/utility_Java) : legacy java intro project

<details>
<summary>Java Hello World</summary>

- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic1
    - Basic operator
        - [TernaryOperator](./src/main/java/Basics/TernaryOperator.java)
    - Array
        - [Array1D](./src/main/java/Basics/Array1D.java)
        - [Array2D](./src/main/java/Basics/Array2D.java)
        - [ArrayClassDemo](./src/main/java/Basics/ArrayClassDemo.java)
        - Array in memory (java)
            - every valuable in the method is "local" valuable 
            - "local" valuable will be put into the "Stack"
            - Any object from "new" will be put into the "Heap"
    - Class
        - [Class Demo1](./src/main/java/Basics/ClassDemo1.java)
        - [Class Demo2](./src/main/java/Basics/ClassDemo2.java)
        - [Attr VS Local Variable1 Demo1](./src/main/java/Basics/AttrVSLocalVariable1.java)
    - Methods
        - [Dynamic Numbers of Var1](./src/main/java/Basics/DynamicNumVar1.java)

    - Value Reference/Assignment:
        - Assignment
            - [Value Assignment1](./src/main/java/Basics/ValueAssignment1.java)
            - [Value Assignment2](./src/main/java/Basics/ValueAssignment2.java)
            - implemented Ordering (1->2->3->4, meaning : 4) will be the final value)
                - 1) default initial values
                - 2) explicit initial values
                - 3) assigne values via constructor
                - 4) getter, setter. e.g. "class.method", "class.attr"
        - Transfer
            - [valueTransfer1](./src/main/java/Basics/valueTransfer1.java)
            - [valueTransfer2](./src/main/java/Basics/valueTransfer2.java) : plz refer this [video](https://www.youtube.com/watch?v=26FZPGNSZlg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=211)
            - [valueTransfer3](./src/main/java/Basics/valueTransfer3.java)
            -  Concepts
                - Basic data type :  assigned value is the storage "actual value"
                - Reference data type :  assigned value is the storage "address value" (e.g. : 0X111, 0XABC)
    - Recursion
        - [Recursion1](./src/main/java/Basics/Recursion1.java)
        - [Recursion2](./src/main/java/Basics/Recursion2.java)

    - Others
        - [GetArgsFromCli](./src/main/java/Basics/GetArgsFromCli.java)

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ClassDemo2.svg"></p>
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/class_in_memory.svg"></p>

- Array1D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array1DimMemory.svg"></p>
- Array2D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array2DimMemory.svg"></p>


- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic2 : OOP/class
    - Java class and its class members:
        - field
        - method
        - constructor
        - code
        - internal class
    - OOP features:
        - Encapsulation
        - Inheritance
        - Polymorphism
    - Other key words
        - this, super, static, final, abstract, interface, package

    - Steps:
        - step 1: create class, design elements in class
        - step 2: create class instance
        - step 3: call the method, attr... inside class via `class.attr`, `class.method`

    - java : "everything is an object"
        - we encapsulate functionality, structure ... into the class, and use them via instantiate the class.
        ```
        Frontend       Backend                  DB
        --------       --------               --------
        pom       -->   Class object   -->    table
        (HTML)    <--   (Java)         <--    (Mysql, Postgre...)
        (CSS)                 
        (JS)
        ```
    - Anonymous Object
        - [AnonymousObject1](./src/main/java/Basics/AnonymousObject1.java)
        - [AnonymousObject2](./src/main/java/Basics/AnonymousObject2.java)***

    - Overloading
        - In same class, if `more than one methods are with same name, but WITH DIFFERENT PRRAMETER NUMBERS OR DIFFERENT PRRAMETER TYPE`
        - [Overloading1](./src/main/java/Basics/Overloading1.java)
        - [Overloading2](./src/main/java/Basics/Overloading2.java)

    - Constructor
        - Intro :
            - create class instance (*** here the "Person_1" is the DEFAULT CONSTRUCTOR; rather than class)
            - (if there no given constructor, java will have a default one)
            - create class instance = new + "constructor"
        - Use case :
            - create class instance
            - `Initialize the instance attr`
        - [Constructor1](./src/main/java/Basics/Constructor1.java)
        - [Constructor2](./src/main/java/Basics/Constructor2.java)
        - [Constructor3](./src/main/java/Basics/Constructor3.java)
        - [ConstructorDemo1](./src/main/java/Basics/ConstructorDemo1.java)
    - Encapsulation
        - [Encapsulation1](./src/main/java/Basics/Encapsulation1.java)
        - In short :
            - hide the things need to hide : users don't need to know how does the library/Class... do the implementation
            - export the things need to export : users only need to know the how/where (e.g. : `API`) to use the library/Class.
        - pros : make the code extenable, scalable, easy to maintain
    - JavaBean
        - [CustomerBean](./src/main/java/Basics/CustomerBean.java)
        - A java class that has below properties
            - 1. the class is a `public` class
            - 2. with a `no argument` `public` constructor
            - 3. has corresponding getter, setter methods
    - This
        - [thisDemo1](./src/main/java/Basics/thisDemo1)
        - [thisDemo2](./src/main/java/Basics/thisDemo2)

- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic3
    - Static demo
        - [staticDemo 1](./src/main/java/Basics/staticDemo1.java)
        - [staticDemo 2](./src/main/java/Basics/staticDemo2.java)
    - Singleton pattern
        - Only allow some classes be existing in some specific class instances
            -> can save resources
            - [ref1](https://blog.csdn.net/Richchigga/article/details/103133472)
            - [ref2](https://www.itread01.com/content/1547084653.html)
            - [ref-scala](https://github.com/yennanliu/utility_Scala)
            - [SingletonDemo1](./src/main/java/Basics/SingletonDemo1.java)
            ```
            # Steps
            1. make constructor private
            2. make object inside class
            3. export a public static method 
            4. implement the code
            ```
            ```java
            // https://www.youtube.com/watch?v=b-UAaq-G4uI&list=PLmOn9nNkQxJEqCNXBu5ozT_26xwvUbHyE&index=91

            // Method 1) : 餓漢式
            // pros : Thread safety
            // cons : could create a class, but not uses it -> resource wasting
            class Single{
                public Single() {}; // make constructor private
                private static Single s = new Single();
                public static Single getInstance(){
                    return s;
                }
            }

            // Method 2) : 懶漢式
            // pros : no resource wasting, only make the instance when need it
            // cons : Thread safety concern
            class Single2{
                private Single2(){}
                private static Single2 s = null;
                public static Single2 getInstance(){
                    if (s == null){
                        s = new Single2();
                    }
                    return s;
                }
            }

            // Method 3) : static internal method
            // optimize with above method 1), and 2)
            // pros : 1. no resource wasting, only make the instance when need it
            // pros : 2. Thread safety (no interruption when running)
            class Singleton{
                private Singleton(){};
                private static class SingltonInstance{ // make it private
                    private static  final Singleton INSTANCE = new Singleton();
                }
                // export below static method to public
                public static Singleton getInstance(){
                    return SingltonInstance.INSTANCE;
                }
            }
            ```


- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic4
    - Thread demo
        - [ThreadDemo_1](./src/main/java/thread/ThreadDemo_1.java)
        - [RunnableDemo_1](./src/main/java/thread/RunnableDemo_1.java)
        - [CallableDemo_1](./src/main/java/thread/CallableDemo_1.java)
    - Thread case study : box office
        - `part 1`
            - [ThreadDemo_2](./src/main/java/thread/ThreadDemo_2.java)
            - [RunnableDemo_2](./src/main/java/thread/RunnableDemo_2.java)
        - `part 2`
            - [MultiSalesThread](./src/main/java/thread/MultiSalesThread.java)
            - [MultiSalesThreadSynchronized](./src/main/java/thread/MultiSalesThreadSynchronized.java)
    - Other Thread examples
        - [CallableThreadDemo_1](./src/main/java/thread/CallableThreadDemo_1.java)
        - [DamonThread_Demo1](./src/main/java/thread/DamonThread_Demo1.java)
        - [ThreadWithPriority](./src/main/java/thread/ThreadWithPriority.java)
        - [ThreadSleep](./src/main/java/thread/ThreadSleep.java)
        - [ThreadYield](./src/main/java/thread/ThreadYield.java)
        - [ThreadJoin](./src/main/java/thread/ThreadJoin.java)
    - Thread Lock
        - [ThreadSynchronizeed](./src/main/java/thread/ThreadSynchronizeed.java)
        - [LockThread](./src/main/java/thread/ThreadLock.java)
    - Getter & Setter
        - [GetterSetterDemo1](./src/main/java/Basics/GetterSetterDemo1.java)
        - [GetterSetterDemo2](./src/main/java/Basics/GetterSetterDemo2.java)

</details>

- [Spring web](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringWeb)
- [Spring Twitter](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringTwitter)
    - endpoint : 
        - http://localhost:8080/api/v1/?search=trump
        - http://localhost:8080/test1

## Quick start
```
mkdir -p src/main/java/hello
# check maven version
mvn -v
# build the project
mvn compile
```

### Package the project
```
mvn package
```

### Run
```
java -jar target/gs-maven-0.1.0.jar
```

### Test 
```
mvn test
```

### Ref
- https://spring.io/guides/gs/maven/
- Java learning ref
    - https://www.itread01.com/content/1542679410.html
- Spring Boot API Tutorial
    - [tutorialspoint Spring Boot API](https://www.tutorialspoint.com/spring_boot/spring_boot_building_restful_web_services.htm)
    - Build API for travel management
        - [part 1](https://mari-azevedo.medium.com/building-a-restful-api-with-java-and-spring-framework-part-1-6c364a885831)
        - [part 2](https://mari-azevedo.medium.com/construindo-uma-api-restful-com-java-e-spring-framework-parte-2-7a6c3e2ad453)
        - [part 3](https://mari-azevedo.medium.com/construindo-uma-api-restful-com-java-e-spring-framework-parte-3-ab34fcc00dee)
        - [part 4](https://mari-azevedo.medium.com/construindo-uma-api-restful-com-java-e-spring-framework-parte-4-6287f68ffc3c?source=follow_footer---------0----------------------------)
            - https://github.com/mariazevedo88/travels-api
            - https://github.com/mariazevedo88/travels-java-api
- Spring MVC Tutorial
    - EN
        - https://www.tutorialspoint.com/spring/index.htm
    - ZH
        - http://tw.gitbook.net/spring/spring_overview.html
