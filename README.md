## Main project
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

- [Spring web](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringWeb)
- [Spring REST](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringREST)
- [Spring RESTService](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringRESTService)

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
