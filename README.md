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
        - String
            - String basic method demo
                - [String method](./src/main/java/Advances/StringMethod)
            - String <--> other class/dtype transform demo
                - [String transform](./src/main/java/Advances/StringTransform)
            - String VS StringBuffer VS StringBuilder
                - [StringBufferStringBuilder1](./src/main/java/Advances/StringBufferStringBuilder1)
    - Basics Data Types VS Wrapper
        - Wrapper can "encapsulate" basic data type -> make them has `object` properties (for OOP)
        - so can use object method, such as toString, equals, hashcode...
        - [WrapperDemo1](./src/main/java/Basics/WrapperDemo1/WrapperTest.java)
            - [WrapperDemo1-1](./src/main/java/Basics/WrapperDemo1/WrapperTest2.java)
            - [WrapperDemo1-2](./src/main/java/Basics/WrapperDemo1/WrapperTest3.java)
            - [WrapperDemo1-4](./src/main/java/Basics/WrapperDemo1/WrapperTest4.java)
        - [WrapperDemo2](./src/main/java/Basics/WrapperDemo2)
        - Need to pickup
            - Basic type <--> Wrapper <--> String
        ```java
        // basic type, wrapper -> String class
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);

        Double d1 = new Double(12.34);
        String str3 =  String.valueOf(d1);

        // String class -> basic type, wrapper
        int num2 = Integer.parseInt(str1);

        String  str2 = "true";
        Boolean b1 = Boolean.parseBoolean(str2);

        // wrapper -> basic type
        Integer in1 = new Integer(12);
        int in1_ = in1.intValue();
        ```
        - "autoboxing", "unboxing"
        ```java
        // autoboxing
        int num = 10;
        Integer in1 = num;
        
        // unboxing
        int in3 = in1;
        ```
    
        - <p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/basic_types_wrapper.png"></p>

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
    - Collection
        - [Collection Demo1](./src/main/java/Advances/CollectionDemo/demo1.java)
        - [Collection Demo2](./src/main/java/Advances/CollectionDemo/demo2.java)
        - [Collection Demo3](./src/main/java/Advances/CollectionDemo/demo3.java) : collection <--> array
        - [Iterator Demo1](./src/main/java/Advances/CollectionDemo/IteratorDemo1.java)
        - [foreach Demo1](./src/main/java/Advances/CollectionDemo/foreachDemo1.java)
        - List
            - [List Demo1](./src/main/java/Advances/CollectionDemo/ListDemo1.java)
            - Iterator methods : foreach, Iterator 
        - Set
            - [Set Demo1](./src/main/java/Advances/CollectionDemo/SetDemo1.java)
            - Set, HashSet : "comparision" method : TreeSet : hashCode(), equals()
        - LinkedHashSet
            - [LinkedHashSet Demo1](./src/main/java/Advances/CollectionDemo/LinkedHashSetDemo1.java)
        - TreeSet
            - [TreeSet Demo1](./src/main/java/Advances/CollectionDemo/TreeSetDemo1.java)
            - "comparision" method : TreeSet : compareTo(), compare()
    - Map
        - [Map Demo1](./src/main/java/Advances/MapDemo/demo1.java) : concepts, properties
        - [Map Demo2](./src/main/java/Advances/MapDemo/demo2.java) : methods
    - TreeMap
        - [TreeMap Demo1](./src/main/java/Advances/TreeMap/demo1.java)
    - `Properties`
        - [Properties Demo1](./src/main/java/Advances/Properties/demo1.java)
    - `Collections` : Collection tool
        - NOTE : `Collections` is NOT a data structure, but a tool class for operating data structures (e.g. Set, List, Map..) under collection
        - [Collections Demo1](./src/main/java/Advances/Collections/demo1.java)
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
        - [System getProperties Demo](./src/main/java/Advances/SystemGetPropertiesDemo1.java)
        - [BigInteger BigDecimal Demo](./src/main/java/Advances/BigIntegerBigDecimalDemo1.java)
        - [Enumeration](./src/main/java/Advances/Enumeration) - Enumeration (枚舉類) demo 
        - [Annotation](./src/main/java/Advances/Annotation) - Annotation (註解) demo

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
        - inner class
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
    - Getter & Setter
        - [GetterSetterDemo1](./src/main/java/Basics/GetterSetterDemo1.java)
        - [GetterSetterDemo2](./src/main/java/Basics/GetterSetterDemo2.java)

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
        - [objectDemo2](./src/main/java/Basics/objectDemo2)
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

    - toString()
        - [EqualsDemo1](./src/main/java/Basics/ToString_1.java)
    - For loop
        - [forLoop1](./src/main/java/Basics/forLoop1.java) : endless for loop
        - [forLoop2](./src/main/java/Basics/forLoop2.java) : for loop (ArrayList) demo
      - [forLoop3](./src/main/java/Basics/forLoop3.java) : for loop (Hashmap) demo

- [JavaHelloWorld](./tree/main/src) : basic3
    - Static demo
        - Can be used in `attribution`, `method`, `code block`, `inner class`
        - Static attribution
            - with `static` : static attr
                -> every instance use THE SAME attr
                -> when modify attr in one instance, will modify others as well
            - Not with static : non-static attr (instance attr)
                -> every instance has its own attr
                -> when modify attr in one instance, will NOT accect others
            ```
                        static attr    |  non static attr
            class         yes          |    no     (can class call attr ?)
            instance      yes          |    yes    (can instance call attr ?)
            
            ```
        - Static method
            - lives in method's "static area"
            - `static method` is loaded when `class` is loaded
            - `static method` CAN ONLY call `static method` or `static attr`
            - `non static method` CAN call both : `static/non-static method` and `static/non-static attr`
            - `this`, `super` are NOT allowed in static method
            ```
                        static method  |  non static method
            class         yes          |    no     (can class call method ?)
            instance      yes          |    yes    (can instance call method ?)
                         
            ```
        - When to use `static attr` ?
            - attr can be used by multitple classes, and they are unchanged from class to class
        
        - When to use `static method` ?
            - method which use static attr
            - constant in class (as attr) are usually declared as `static`
            - methods in util class 
                - (can use directly, no need to instantiate class)
                - e.g. Math, Array, Collections
        - [staticDemo 1](./src/main/java/Basics/staticDemo1.java)
        - [staticDemo 2](./src/main/java/Basics/staticDemo2.java)
        - [staticDemo 3](./src/main/java/Basics/staticDemo3.java)
        - [staticDemo 4](./src/main/java/Basics/staticDemo4.java)
        - [staticDemo 5](./src/main/java/Basics/staticDemo5.java)
        - [staticDemo 6](./src/main/java/Basics/staticDemo6)

    <p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/static1.svg"></p>

    - Design pattern : `Singleton` 
        - Can only `create ONE class instance` -> reduce system loading
        - Only allow some classes be existing in some specific class instances
            -> can save resources
            - [ref1](https://blog.csdn.net/Richchigga/article/details/103133472)
            - [ref2](https://www.itread01.com/content/1547084653.html)
            - [ref-scala](https://github.com/yennanliu/utility_Scala)
            - [SingletonDemo1](./src/main/java/Basics/SingletonDemo1.java)
            - [SingletonDemo2](./src/main/java/Basics/SingletonDemo2.java) : Singleton - Eager initialization
            - [SingletonDemo3](./src/main/java/Basics/SingletonDemo3.java) : Singleton - Lazy initialization
            - [SingletonDemo4](./src/main/java/Basics/SingletonDemo4.java)
            - [SingletonDemo5](./src/main/java/Basics/SingletonDemo5.java)
            - [LazyInitSynchronized1](./src/main/java/Advances/LazyInitSynchronized1) : solve Lazy initialization's thread safety with synchronized method
            ```
            # Steps
            1. make constructor private
            2. make object inside class
            3. export a public static method 
            4. implement the code
        - Lazy initialization VS Eager initialization
            - Lazy initialization : 
                - pros : delay instance create (load fast)
                - cons : thread un-safety --> need to use "multi-thread"
            - Eager initialization:
                - pros : thread safety (data, process in different threads `NOT` affect each other)
                - cons : takes time to load

            ```
            ```java
            // https://www.youtube.com/watch?v=b-UAaq-G4uI&list=PLmOn9nNkQxJEqCNXBu5ozT_26xwvUbHyE&index=91

            // Method 1) : 餓漢式 (Eager initialization)
            // pros : Thread safety
            // cons : could create a class, but not uses it -> resource wasting
            class Single{
                public Single() {}; // make constructor private
                private static Single s = new Single();
                public static Single getInstance(){
                    return s;
                }
            }

            // Method 2) : 懶漢式 (lazy initialization)
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

    - Design pattern : `Template`
        - [TemplateDemo1](./src/main/java/Basics/TemplateDemo1.java)
        - [TemplateDemo2](./src/main/java/Basics/TemplateDemo2.java)
        - Common use cases:
            - DB op
            - Junit for unit test
            - Java Web (e.g. spring MVC) : Servlet's doGet/do/Post method
            - JDBC (spring)

    - Design pattern : `Proxy`
        - [ProxyDemo1](./src/main/java/Basics/ProxyDemo1.java)
        - [ProxyDemo2](./src/main/java/Basics/ProxyDemo2.java)
        - Offers an agent (proxy) that help access control on the specific class
            - -> So users can access the `agent` class only rather than "proxied" class
        - using case:
            - safety -> prevent actual class to be visited directly
            - remote proxy -> RMI
            - delay loading -> load the proxy class first, if needed, load the actual class
    - Design pattern : `Factory`
        - Simple Factory
            - [ProxyDemo1](./src/main/java/Basics/FactoryDemo1)
        - Factory Method
            - [ProxyDemo2](./src/main/java/Basics/FactoryDemo2)
        - Abstract Factory
            - diff between Abstract Factory VS Factory Method
                -> complexity when create class
    - Final
        - Can decorate : class, method, attr
        - Final class
            - CAN'T BE EXTENDED (no sub class)
            - example : String, System, StringBuffer
        -  Final method
            - CAN'T BE OVERRIDDEN (no overwrite method)
            - example : getClass() method in Object class
        - [FinalDemo1](./src/main/java/Basics/FinalDemo1.java)
    - Code block
        -  purpose : for class, object initializing
        -  static code block
            - *** Executed when class is loaded (since it's static)
            - will only run ONCE
            - init class attr, inform
        -  non-static code block
            -  *** Executed when class is instantiated
            -  *** can init class attr when instantiate the class
        - [Block_demo1](./src/main/java/Basics/Block_demo1.java)
        - [Block_demo2](./src/main/java/Basics/Block_demo2)
   - Abstract
        - [AbstractDemo1](./src/main/java/Basics/AbstractDemo1.java)
        - [AbstractDemo2](./src/main/java/Basics/AbstractDemo2)
        - [AbstractDemo3](./src/main/java/Basics/AbstractDemo3/PersonTest.java)
        - [AbstractDemo4](./src/main/java/Basics/AbstractDemo4)
        - Can decorate
            - class
            - method
        - abstract class
            - CAN NOT BE instantiated
            - STILL NEED CONSTRUCTOR (used in sub class)
            - in development, we always offer sub class that can instantiate via above
        - abstract method
            - ONLY has method declare, has NO code body (method implementation)
            - inference : if a class has abstract method -> this class must be an ABSTRACT CLASS
            - Abstract class can has NO abstract method
            - if sub class overwrites all abstract methods in super class -> sub class CAN instantiate
            - if sub class NOT overwrites all abstract methods in super class -> sub class CAN NOT instantiate, this sub class is also an abstract class
    - Interface
        - [interfaceDemo1](src/main/java/Basics/interfaceDemo1.java)
        - [interfaceDemo2](src/main/java/Basics/interfaceDemo2.java)
        - [interfaceDemo3](src/main/java/Basics/interfaceDemo3.java)
        - [interfaceDemo4](src/main/java/Basics/interfaceDemo4)
        - [interfaceDemo5](src/main/java/Basics/interfaceDemo5)
        - [interfaceDemo6](src/main/java/Basics/interfaceDemo6)
        - use keyword "interface"
        - in java, interface, and class are the structure in the same level
        - how to define interface ? elements inside interface ?
            - JDK 7 and before
                - -> can ONLY use global constant and abstract method
                - -> global constant : public static final (public static final can be omitted)
                - -> abstract method : public abstract (public abstract can be omitted)
            - JDK 8 and after
                - -> can HAVE global constant, abstract method, static method, default method
        - CAN NOT define constructor in interface
            - interface CAN NOT be instantiated
        - in java, we usually use CLASS to "implement" interface (not extend)
            - -> if class implements all abstract methods in interface -> this class can be instantiated
            - -> if class NOT implement all abstract methods in interface -> this class CAN NOT be instantiated
    - Inner Class
        - [InnerClassDemo1](src/main/java/Basics/InnerClassDemo1.java)
        - [InnerClassDemo2](src/main/java/Basics/InnerClassDemo2.java)
        - [InnerClassDemo3](src/main/java/Basics/InnerClassDemo3.java)

- [JavaHelloWorld](./tree/main/src) : basic4
    - Unit Tests
        - [JUnit_1](./src/main/java/Basics/JUnit_1)
    - Exception
        - [ExceptionDemo1](./src/main/java/Basics/ExceptionDemo1.java)
        - [ExceptionDemo2](./src/main/java/Basics/ExceptionDemo2.java)
        - [ExceptionDemo3](./src/main/java/Basics/ExceptionDemo3.java)
        - [ExceptionDemo4](./src/main/java/Basics/ExceptionDemo4.java)
        - [ExceptionDemo5](./src/main/java/Basics/ExceptionDemo5)
        - [ExceptionDemo6](./src/main/java/Basics/ExceptionDemo6)
        - [ExceptionDemo7](./src/main/java/Basics/ExceptionDemo7)
        - [ExceptionDemo8](./src/main/java/Basics/ExceptionDemo8.java)
        - [ExceptionDemo9](./src/main/java/Basics/ExceptionDemo9)
        - "throw" - "get" model
            - `throw`
                - in `runtime`
                - When program runs, once there is an exception
                    - -> will generate an exception obj at the running code
                -  throw can from
                    - -> system auto generated
                    - -> set up by developer
            - `get`
                 - method that deal with exception
                 - two types
                    - 1. try-catch-finally
                        - `compile`
                    - 2. throws
                - `try-catch-finally`
                    - Know the exception cases, can handle them in cases
                - throws + `exception type`
                    - Have unhandled exception, so the program will throw the exception to `upper` layer anyway. If upper layer still CAN'T solve it, will pass to upper layer, and ... (repeat it till meet highest layer)
                - There are only 2 ways deal with exception:
                    - `try-catch-exception`
                        - -> Really deal with the exception on place
                    - `throws`
                        - -> NOT really deal with the exception,
                        - -> only "throws" the exception to the upper layer.
                        - (upper layer still need to deal with such exception)


- [JavaHelloWorld](./src/main/java/Advances) : Advanced
    - `Program VS Process VS Thread`
        - Program : collection of code for purpose, a static instance
        - Process : `running process` of the program, or `a running program`. is a dynamic process. has its cycle : launch - exist - terminate
            - examples
                - running spotify
                - running whatsapp
            - Program is `static` ; while process is `dynamic`
            - Process as `resource allocation` unit, will allocate threads to different memory spaces
        - Thread : A process has `multiple` thread. Each thread is an execution unit inside the program
            - if one process can run multiple threads `in parallell` -> We say it's a `mutiple threading` program
            - thread as an allocation & execution unit, each thread has its independent running thread and counter (pc)
            - Multiple threads in the same process CAN USE `same storage unit / memory space ..` -> they allocate instance from the same `heap`
                -> but such memory sharing mechanisms may cause `thready safety` concerns.
        - `Parallelism (並行) VS Concurrency (並發)`
            - Parallelism : multiple CPUs run different tasks. e.g. multiple people do different stuffs
            - Concurrency : One CPU does different tasks (jump between tasks). e.g. one person does different stuffs
    - Process
    - Thread
        - A `thread` is a thread of execution in a program. The JVM allows an application to have multiple threads of execution running concurrently.
        - Thread create and use
        - Thread life cycle
        - Thread sync
        - Thread communication
        - Thread create and use (JDK 5.0)
        - [ThreadDemo1](src/main/java/Advances/ThreadDemo1.java)
        - [ThreadDemo2](src/main/java/Advances/ThreadDemo2.java)
        - [ThreadDemo3](src/main/java/Advances/ThreadDemo3.java)
        - [ThreadDemo4](src/main/java/Advances/ThreadDemo4) : common thread methods demo
        - [ThreadDemo5](src/main/java/Advances/ThreadDemo5)
        - [ThreadDemo6](src/main/java/Advances/ThreadDemo6) : Callable interface (new in JDK 5.0)

            - [RunnableDemo1](src/main/java/Advances/ThreadDemo5/RunnableDemo1.java) : Runnable create multi thread demo
        - Thread Safety
            - ThreadSafety1
                - [BoxOfficeThread1.java](src/main/java/Advances/ThreadSafety1/BoxOfficeThread1.java) : thread (Thread) safety ("Synchronized code block")
                - [BoxOfficeThread2.java](src/main/java/Advances/ThreadSafety1/BoxOfficeThread2.java) : thread (Thread) safety ("Synchronized method")
                - [BoxOfficeRunnable1.java](src/main/java/Advances/ThreadSafety1/BoxOfficeRunnable1.java) : thread (Runnable) safety ("Synchronized code block")
                - [BoxOfficeRunnable2.java](src/main/java/Advances/ThreadSafety1/BoxOfficeRunnable2.java) : thread (Runnable) safety ("Synchronized method")
                - [explanation](https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/ThreadSafety1/BoxOfficeRunnable1.java#L9)
            - ThreadSafety2
                - [ThreadSafety2](src/main/java/Advances/ThreadSafety2) : thread safety via "lock"
            - ThreadSafety3
                - [ThreadSafety3](src/main/java/Advances/ThreadSafety3) : thread safety example : bank account (synchronized method)
        - ThreadCommunication
            - [ThreadCommunication1](src/main/java/Advances/ThreadCommunication1) : Thread communication methods demo (wait(), notify(), notifyAll())
            - [ThreadCommunication2](src/main/java/Advances/ThreadCommunication2) : Thread communication demo : producer, consumer
            - Thread Communication methods:
                - 1) wait():
                    - once run this method, the thread will be in `blocked` status and RELEASE Synchronized monitor (lock)
                - 2) notify():
                    - once run this method, the thread will be "WAKED UP", if there are multiple threads, the first priority thread will be waked up
                - 3) notifyAll():
                    - once run this method, ALL of the OTHER threads will be "WAKED UP"
        - Thread Dead Lock
            - [DeadLock1](src/main/java/Advances/DeadLock1) : Dead Lock demo 1
        - [ThreadDemo_1](./src/main/java/thread/ThreadDemo_1.java)
        - [RunnableDemo_1](./src/main/java/thread/RunnableDemo_1.java)
        - [CallableDemo_1](./src/main/java/thread/CallableDemo_1.java)
        - Thread Pool
            - [ThreadPool1](src/main/java/Advances/ThreadPool1)
        - 4 ways create multi thread
            - Method 1) : Inherit `Thread` class
                - Thread class is implemented from Runnable interface actually
                ```java
                // java
                public class Thread implements Runnable
                ```
            - Method 2) : Implement `Runnable` interface
                - we prefer Implement Runnable in general
                    - reason 1) without single class inheritance limitation (Runnable is a interface)
                    - reason 2) the attr/val .. are shared by multi thread by default (because the implementation way)
                    ```java
                    // java
                    MyWindow my_window = new MyWindow();

                    Thread t1 = new Thread(my_window); 
                    Thread t2 = new Thread(my_window); 
                    Thread t3 = new Thread(my_window);
                    ```
            - Note : We need to overwroide run() method in both 2 methods

            - Method 3) : Callable + Future
            - Method 4) : Thread pool 

        - Thread Cycle
            <p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_cycle2.svg"></p>
        - Case study
            - box office
            - `part 1`
                - [ThreadDemo_2](./src/main/java/thread/ThreadDemo_2.java)
                - [RunnableDemo_2](./src/main/java/thread/RunnableDemo_2.java)
            - `part 2`
                - [MultiSalesThread](./src/main/java/thread/MultiSalesThread.java)
                - [MultiSalesThreadSynchronized](./src/main/java/thread/MultiSalesThreadSynchronized.java)
        - Other examples
            - [CallableThreadDemo_1](./src/main/java/thread/CallableThreadDemo_1.java)
            - [DamonThread_Demo1](./src/main/java/thread/DamonThread_Demo1.java)
            - [ThreadWithPriority](./src/main/java/thread/ThreadWithPriority.java)
            - [ThreadSleep](./src/main/java/thread/ThreadSleep.java)
            - [ThreadYield](./src/main/java/thread/ThreadYield.java)
            - [ThreadJoin](./src/main/java/thread/ThreadJoin.java)
        - Thread Lock
            - [ThreadSynchronizeed](./src/main/java/thread/ThreadSynchronizeed.java)
            - [LockThread](./src/main/java/thread/ThreadLock.java)

    - Generic type
        - [demo 1](./src/main/java/Advances/Generic/demo1.java) : Generic intro
        - [demo 2](./src/main/java/Advances/Generic/demo2.java) : Generic type with custom class demo
        - [demo 3](./src/main/java/Advances/Generic/demo3.java) : Generic with custom structure
        - [demo 4](./src/main/java/Advances/Generic/demo4.java) : Generic method demo
        - [demo 5](./src/main/java/Advances/Generic/demo5.java) : Generic class demo (example : DAO)
        - [demo 6](./src/main/java/Advances/Generic/demo6.java) : Generic type with inheritance, wildcard
        - [demo 7](./src/main/java/Advances/Generic/demo7.java) : Generic type with limited condition
        - [demo 8](./src/main/java/Advances/Generic/demo8.java) : Generic type example1
        - [demo 9](./src/main/java/Advances/Generic/demo9.java) : Generic type example2

    - IO
        - File IO
            - [File IO 1](./src/main/java/Basics/fileIO1.java)
            - [File IO 2](./src/main/java/Basics/fileIO2.java)
            - [demo 1](./src/main/java/Advances/FileIO/demo1.java) : File IO basic
            - [demo 2](./src/main/java/Advances/FileIO/demo2.java) : File IO common methods
    
        - IO flow
            - [IO 1](./src/main/java/Advances/IOFlow/demo1.java) : FileReader demo           
            - [IO 2](./src/main/java/Advances/IOFlow/demo2.java) : FileWriter demo
            - [IO 3](./src/main/java/Advances/IOFlow/demo3.java) : File copy (txt)
            - [IO 4](./src/main/java/Advances/IOFlow/demo4.java) : File copy (picture)
            - [IO 5](./src/main/java/Advances/IOFlow/demo5.java) : make File copy as funciton
            - [IO 6](./src/main/java/Advances/IOFlow/demo6.java) : File copy (picture) : Buffered IO flow
            - [IO 7](./src/main/java/Advances/IOFlow/demo7.java) : File copy (txt): BufferedReader, BufferedFileWriter
            - [IO 8](./src/main/java/Advances/IOFlow/demo8.java) : File encrypt/decrypt demo

        - IO flow2
            - [demo1](./src/main/java/Advances/IOFlow2/demo1.java) : Transformation flow demo : InputStreamReader, OutputStreamWriter

        - IO flow3
            - [demo1](./src/main/java/Advances/IOFlow3/demo1.java) : standard input and output stream: System.in, System.out
            - [demo2](./src/main/java/Advances/IOFlow3/demo2.java) : DataInputStream, DataOutputStream demo
        - ObjectInputOutputFlow
            - [demo1](./src/main/java/Advances/ObjectInputOutputFlow/demo1.java) : `serialization`, `deserialization` basic demo
            - [demo2](./src/main/java/Advances/ObjectInputOutputFlow/demo2.java) : `serialization`, `deserialization` with custom java class
        - RandomAccessFile
            - [demo1](./src/main/java/Advances/RandomAccessFile/demo1.java) : RandomAccessFile input, and output flow demo
        - NIO
            - [demo1](./src/main/java/Advances/nio/demo1.java) 

    - TimeStamp API
        -  DateTime API before JDK 8
            - 1) System.currentTimeTimeMillis();
            - 2) java.util.Date and its sub class java.sql.Date
            - 3) SimpleDateFormat
            - 4) Calendar
        - [DateTimeApi](src/main/java/Advances/DateTimeApi) : date, timestamp.. API demo
            - [demo1](src/main/java/Advances/DateTimeApi/demo1.java) : basic constructors, methods
            - [demo2](src/main/java/Advances/DateTimeApi/demo2.java) : java.text.SimpleDateFormat, Calendar
        - [CalendarApi](src/main/java/Advances/CalendarApi) : Calendar API demo
        - [LocalDateTime](src/main/java/Advances/LocalDateTime) : LocalDate, LocalTime, LocalDateTime API demo
        - [InstantApi](src/main/java/Advances/InstantApi) : Instant API demo
        - [DateTimeFormatterApi](src/main/java/Advances/DateTimeFormatterApi) : DateTimeFormatter API demo

    - Compare API
        - [ComparableComparator](src/main/java/Advances/ComparableComparator) : Comparable, Comparator API demo

- [JavaHelloWorld](./src/main/java/Advances) : Advanced data structure
    - String class
        - [StringClass](src/main/java/Advances/StringClass)

- [JavaHelloWorld](./tree/main/src) : Mini project
    - [CustomerCRM](./src/main/java/Basics/CustomerCRM)
    - [EmployeeCRM](./src/main/java/Basics/EmployeeCRM)

- [JavaHelloWorld - Utils](./tree/main/src/utils) : General Util class

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
- Java interview questions
    - https://www.interviewbit.com/java-interview-questions?utm_source=midfunnel&utm_medium=email&utm_campaign=none_scaler_academy_midfunnel_email_newsletter_india_all
- Java learning ref
    - https://www.itread01.com/content/1542679410.html
- Spring Boot API Tutorial
    - https://spring.io/guides/gs/maven/
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
