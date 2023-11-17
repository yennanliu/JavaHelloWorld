# Multithreading

## General programming steps

- [Video](https://youtu.be/Qxj3CXqh4Wk?si=zoFHx85gSB6tUZVT&t=575)

- Step 1: Create resource class, implement attr, op method
- Step 2: implement method in resource class
	- decision
	- main biz logic
	- notification (other thread)
- Step 3: Create threads, call resource class
- Step 4: Avoid "虛假喚醒" (do decision via "while", instead of "if")

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/spurious_wakeup.png"></p>

## Command

```bash
#java -jar fernflower.jar -dgs=true JarToDecompile.jar DecompiledJar
#java -jar ref_project/jcip-examples-src.jar -dgs=true JarToDecompile.jar DecompiledJar
```

## Note

Synchronized : Implicit lock
Lock : explicit lock
Synchronized, Lock are both ReentrantLock (可重入鎖)

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ReentrantLock.png"></p>

Synchronized

	- Every instance in java can lock with "Synchronized" 
	- 3 types
		- synchronized "method" : lock current instance 
		- synchronized "static method" : lock current Class instance 
		- synchronized "code block" : lock instances inside code block

Lock

	- Lock CAN'T be unlocked automatically when exception -> need to unlock explicitly (usually via "finally")
	- Lock can "interrupt" thread; synchronize can't do so (thread in synchronize will keep waiting)
	- Lock Can know if lock is received, synchronize can't do so
	- Lock has better performance than synchronize when heavy resource competition

	- Unfair lock VS fair lock
		- Unfair : good performance, but some threads have nothing to do
		- fair : less performance, but threads work evenly

Collection for `thready safety`

	- List:
		- Vector
		- Collections.synchronizedList(new ArrayList<>())
		- CopyOnWriteArrayList

	- Set:
		- CopyOnWriteArraySet

	- Map:
		- ConcurrentHashMap

## Ref

- https://github.com/callicoder/java-concurrency-examples
- https://github.com/code-review-checklists/java-concurrency

- https://github.com/PacktPublishing/Java-Concurrency-Multithreading-in-Practice/tree/master
- https://jcip.net/
- https://jcip.net/listings.html