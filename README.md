## Main project
- [utility_Java](https://github.com/yennanliu/utility_Java) : legacy java intro project

<details>
<summary>Java Hello World</summary>

- [JavaHelloWorld](./tree/main/src) : basic1
    - Data types
        - Primitive Data Types
            - Int, String, Float, boolean, char....
        - Reference types (Non-Primitive Data Types)
            - user defined. e.g. :
            ```java
            class myClass{
                int id;
                Double age;
            }
            myClass m1 = new myClass;
            ```
        - [ref1](https://www.w3schools.com/java/java_data_types.asp)
        - [ref2](https://www.geeksforgeeks.org/types-references-java/)
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

    - Import
        - [ImportDemo1](./src/main/java/Basics/ImportDemo1.java)

    - Others
        - [GetArgsFromCli](./src/main/java/Basics/GetArgsFromCli.java)

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ClassDemo2.svg"></p>
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/class_in_memory.svg"></p>

- Array1D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array1DimMemory.svg"></p>
- Array2D:
<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/array2DimMemory.svg"></p>


- [JavaHelloWorld](./tree/main/src) : basic2 : OOP/class
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
        - 1. `this` can be used in `attr`, `class`, `method`, `constructor`
        - 2. `this` on  `attr`, `method`
            - this can be referred as "current class"
            - in class, method, we can use "this.method" for calling other method in same class
            - pattern : `this.attr`, `this.method`, `this.constructor`....
        - 3. this call `constructor`
            - in the class's constructor, we use  "this(var) or this() or ..." calling the other constructor in the same class
            - CAN'T call itself (constructor) (via this())
            - calling constructor via `this()` need to be in the `1st line` of code
            - can only use `1` `this()` inside a constructor
            - if constructor's variable is as same as class's variable => we MUST use `this.var` explicitly
        - [thisDemo1](./src/main/java/Basics/thisDemo1)
        - [thisDemo2](./src/main/java/Basics/thisDemo2.java)
        - [thisDemo3](./src/main/java/Basics/thisDemo3)
        - [thisDemo4](./src/main/java/Basics/thisDemo4.java)
        - [thisDemo5](./src/main/java/Basics/thisDemo5)

    - Extends
        - [Extends_demo1](./src/main/java/Basics/Extends_demo1)
        - [Extends_demo2](./src/main/java/Basics/Extends_demo2)
        - the "children" class can `reuse`, `overwrite` the `attr/method` that their "parent" class already defined
        - general form : `class A extends B{}`
            - A : children class (subclass)
            - B : parent class (superclass)
            - Once A extends from B, A will get all structure, attr, method from B
            - Note : private method CAN'T be called (it is received, but can't be called due to the `encapsulation`) in subclass (child class)
            - Subclass (child class) `CAN STILL define its own method, attr ...` after extending from superclass (parent class)
            - One superclass can have `multiple` subclass
            - A subclass can only have `ONE` superclass
            - superclass - subclass is a `relative` concept
            - It's OK to have "indirect" extends. e.g. : `A extends B, B extends C ....`
            - If there a class that we don't explicitly define its superclass (extends), then this class extends from `java.lang.Object` class by default
            - All classes in java (except java.lang.Object) are `direct/indirect` subclass of  `java.lang.Object`

    - Overwrite
        - [Overwrite_demo1](./src/main/java/Basics/Overwrite_demo1)
        - [Overwrite_demo2](./src/main/java/Basics/Overwrite_demo2)
        - `subclass` can overwrite the same method (same method name, same param) that its `superclass` has
        - Note : For overwrited methods, it's needed to have the same method name, and the same params as the one in superclass (method name + params ) (for overwrite)
        - only `non-static` method can be overwritten
        - access_modifiers
            - method in subclass can have "bigger" `access_modifiers` than its superclass (access_modifiers : private, public, ...)
            - `private` method in superclass `CAN NOT` be overwritten
        - return_value_type
            - if return_value_type is `void` in superclass -> it's needed to be `void` in subclass as well
            - if return_value_type is `A type` in superclass -> the return_value_type in subclass can be "A type" or `any subclass of A type`
            - if return_value_type is `basic data type` (e.g. Int, String, float...) in superclass -> the return_value_type need the be the same basic data type as its superclass
        - Exception_type
            - subclass' Exception_type must be `smaller or equal` than the one in superclass

        ```java
        // pattern
        @override   //  @override is just a comment, not necessary actually
        access_modifiers return_value_type method_name(parames){
        // java code
        }
        // pattern2
        @override
        access_modifiers return_value_type method_name throws Exception_type (parames){
        // java code
        }
        ```
    - Controlling Access
        - [ControllAccess_1](./src/main/java/Basics/ControllAccess_1)
        - [ControllAccess_1_1](./src/main/java/Basics/ControllAccess_1_1)
        - [ref](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

    <p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/access_level.png"></p>

    - Super      
        - [Super_1](./src/main/java/Basics/Super_1)
        - [Super_2](./src/main/java/Basics/Super_2)
        - [Super_3](./src/main/java/Basics/Super_3)
        - [Instance_1](./src/main/java/Basics/Instance_1.java)
        - `super` can be recognized as "superclass relative"
        - super can be called on : attr, method, constructor
        - using
            -  we can call method in superclass explicitly via super.method_name from subclass
            - If method name are same in superclass and subclass -> we need to call method in superclass (current class) explicitly via `super.method`
            - calling subclass's (current class) method : `this.method`
        - super call constructor
            - we can use superclass' constructor in subclass via "super constructor"
            - "super constructor" need to be declared in 1ST LINE of subclass constructor
            - in subclass, we can only chosse either "this constructor" or "super constructor"  (choose one of them !)
            -  if we don't declare any "this constructor" or "super constructor"..  -> it will use "super constructor" (super(), no argument) by default
    - Polymorphism (`Upcasting`)
        - [polymorphism_1](./src/main/java/Basics/polymorphism_1)
        - [polymorphism_2](./src/main/java/Basics/polymorphism_2)
        - [polymorphism_3](./src/main/java/Basics/polymorphism_3)
        - [polymorphism_4](./src/main/java/Basics/polymorphism_4)
        - [polymorphism_5](./src/main/java/Basics/polymorphism_5)
        - [polymorphism_6](./src/main/java/Basics/polymorphism_6)
         - call superclass and point to subclass' instance
        - Polymorphism is actually `Upcasting`
        - Polymorphism NOT working in `attr` (still use its superclass' attr)
        - pattern : 
        ```java 
        superclass p1 = new subclass();
        ```
        - (following above) p1 will be the superclass class type, so it CAN'T use the method that only exist in subclass
        - During compile
            - => can only call methods defined in superclass
        - During runtime
            - => will run the methods overridden in subclass
        - summary :
            - =>  Compile : check left (<-)
            - =>  Running : check right (->)
        - use requirements:
            - there is extends in class (superclass, subclass)
            - method override is necessary
    - `Downcasting`
        - [Downcasting_1](src/main/java/Basics/Downcasting_1)
        - [Downcasting_2](src/main/java/Basics/Downcasting_2)
        - [Upcasting ref](https://www.javatpoint.com/upcasting-and-downcasting-in-java)
        - pattern : 
        ```java 
        // MUST do upperCasting first (?)
        superclass p1 = new subclass();
        // then do downcasting
        subclass x1 = (subclass) p1;
        ```
    - Upcasting VS DownCasting
        - Superclass ---DownCasting---> Subclass
        - Superclass <---Upcasting--- Subclass
        - Summary:
            - `Uppercasting` : make subclass to superclass type
            - `Downcasting` : make superclass to subclass type
            - In dev, we use Uppercasting >> than Downcasting
    <p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/upcasting_downcasting.png"></p>

    - Instanceof
        - [instanceof_1](./src/main/java/Basics/instanceof_1) - instanceof demo
        - `a instanceof A` : check if a is instance of A, if yes, return True, else False
        - using case :
            -> to prevent the "ClassCastException" exception, we use instanceof before we do DownCasting. (if return true, then do `DownCasting`, else do nothing)

    - java.lang.Object
        - [objectDemo1](./src/main/java/Basics/objectDemo1)
            - java.lang.Object basics, properties
            - garbage collect (GC) intro

    - `Equals` VS `==`
         - [EqualsDemo1](./src/main/java/Basics/EqualsDemo1)
         - [EqualsDemo2](./src/main/java/Basics/EqualsDemo2)
         - [EqualsDemo3](./src/main/java/Basics/EqualsDemo3)
         - [EqualsDemo4](./src/main/java/Basics/EqualsDemo4)
        - `==`
            - ==, an operator
            - For comparing `BASIC data type`
            - compare `CONTENT (attr: such as value..)`
            -  If compare "basic data type"
                - type don't need to be the same, ONLY compare their "actual value" in memory
             - If compare "REFERENCE data type"
                - will compare if their address in memory are the SAME
                - e.g. if they are belong to the same instance
        - `Equals`
            - Equals is a method, NOT operator
            - For comparing `Reference data type`
             - compare `address in memory`
            - For some types (class) such as String, Date, File
                - -> They've overridden the equals method
                - -> SO compare if "content" (attr: such as value..) are the SAME; but NOT address
            - In general cases, we want equals to compare "content" rather than address
                - -> so we need to OVERWRITE the equals method

- [JavaHelloWorld](./tree/main/src) : basic3
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


- [JavaHelloWorld](./tree/main/src) : basic4
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
    - MVC
        - model : the layer define data (backend). e.g. : DB, DB class, model.bean
        - view : show data for client (frontend) side. e.g. :  view utils, view UI
        - controller : deal with bisiness logic. e.g. : controller service, controller adapter, controller base

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
