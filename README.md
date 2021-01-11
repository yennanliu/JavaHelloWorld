## Main project
- [https://github.com/yennanliu/utility_Java](utility_Java) : legacy java intro project
- [JavaHelloWorld](https://github.com/yennanliu/JavaHelloWorld/tree/main/src)
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

- [Spring web](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringWeb)
- [Spring REST](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringREST)
- [Spring RESTService](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringRESTService)
- Spring
- SpringMVC
- Mybatis

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
	- https://www.tutorialspoint.com/spring_boot/spring_boot_building_restful_web_services.htm
	- https://mari-azevedo.medium.com/building-a-restful-api-with-java-and-spring-framework-part-1-6c364a885831
		- https://github.com/mariazevedo88/travels-api
		- https://github.com/mariazevedo88/travels-java-api
- Spring MVC Tutorial
	- EN
		- https://www.tutorialspoint.com/spring/index.htm
	- ZH
		- http://tw.gitbook.net/spring/spring_overview.html