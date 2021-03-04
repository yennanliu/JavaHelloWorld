## Main project
- [utility_Java](https://github.com/yennanliu/utility_Java) : legacy java intro project

- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic1
    - Basic operator
        - [TernaryOperator](./src/main/java/Basics/TernaryOperator.java)
    - Array
        - [Array1D](./src/main/java/Basics/Array1D.java)
        - [Array2D](./src/main/java/Basics/Array2D.java)
        - Array in memory (java)
            - every valuable in the method is "local" valuable 
            - "local" valuable will be put into the "Stack"
            - Any object from "new" will be put into the "Heap"
    - Class
        - [Class Demo1](./src/main/java/Basics/ClassDemo1.java)
        - [Class Demo2](./src/main/java/Basics/ClassDemo2.java)
        - [Attr VS Local Variable1 Demo1](./src/main/java/Basics/AttrVSLocalVariable1.java)
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ClassDemo2.svg"></p>
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/class_in_memory.svg"></p>

- Array1D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array1DimMemory.svg"></p>
- Array2D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array2DimMemory.svg"></p>

    - Others
        - [GetArgsFromCli](./src/main/java/Basics/GetArgsFromCli.java)

- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src) : basic2
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
    - Constructor
        - Constructor can define value to its attribution when create the object
        - Constructor aka Constructoring method -> for new object initialization
        - if there NO input arguments
            - java will make one with `NO Constructor` as default
        - if there IS input arguments
            - the one will override the default one (one with NO Constructor as default)
        - java form

        ```java
        [decorator] method(parameters){
            method code
        }
        ```
        - [Constructor1](./src/main/java/Basics/ConstructorDemo1.java)

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

- [Spring web](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringWeb)
- [Spring Twitter](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringTwitter)

## Relative Project
- [utility_Java](https://github.com/yennanliu/utility_Java)

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
