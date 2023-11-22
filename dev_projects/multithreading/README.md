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
```

## Note

- Synchronized : Implicit lock
- Lock : explicit lock
- Synchronized, Lock are both `ReentrantLock (可重入鎖)`
	- so thread can freely visit any component inside once receive a lock
	- [code](https://github.com/yennanliu/JavaHelloWorld/blob/main/dev_projects/multithreading/Multithreading/src/main/java/com/yen/atguigu/lock/course20/SyncLockDemo.java#L24)

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ReentrantLock.png"></p>

1) Synchronized

- Every instance in java can lock with "Synchronized" 
- 3 types
	- synchronized "method" : lock current instance 
	- synchronized "static method" : lock current Class instance 
	- synchronized "code block" : lock instances inside code block

2) Lock

- Lock CAN'T be unlocked automatically when exception -> need to unlock explicitly (usually via "finally")
- Lock can "interrupt" thread; synchronize can't do so (thread in synchronize will keep waiting)
- Lock Can know if lock is received, synchronize can't do so
- Lock has better performance than synchronize when heavy resource competition

- Unfair lock VS fair lock
	- Unfair : good performance, but some threads have nothing to do
	- fair : less performance, but threads work evenly

- Optimistic lock vs pessimistic lock
	- pessimistic lock
		- NOT supprot concurrency op
	- optimistic lock
		- supprot concurrency op
		- via "version" control data consistency

- Table lock VS row lock
	- Table lock : Lock all records in table in DB
	- row lock : ONLY lock a row in table in DB

- Read lock VS write lock
	- BOTH Read, and write lock can cause "dead" lock

- ReadWrite lock
	- A resource can be accessed by multiple read threads, or a write thread, but CAN'T be accessed by write tread and read thread on the same time (讀寫互斥, 讀讀共享)

- Lock `Evolution`
- https://youtu.be/RYGSlLYoesg?si=HJLztBKMm1ZmLdo2&t=529
```
No lock  -----> 讀佔鎖 (synchronized, ReentrantLock)    -----> 讀寫鎖 (ReentrantReadWriteLock)
                 (讀佔, ONLY 1 thread can access resource)            (讀讀共享, 可多人同時讀)(1.鎖飢餓 2. can't write while read)
```

- Lock downgrade (write->read)
	- get write lock -> get read lock -> release write lock -> release read lock
	- ONLY can write lock -> read lock (NOT vise versa)

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/lock_downgrade.png"></p>


3) Collection for `thready safety`

- List:
	- Vector
	- Collections.synchronizedList(new ArrayList<>())
	- CopyOnWriteArrayList

- Set:
	- CopyOnWriteArraySet
	
- Map:
	- ConcurrentHashMap

4) How to create Thread ?

- Thread

- Runnable
	- run(): NO return value, CAN'T throw exception

- Callable
	- call() : 
		- CAN have return value, Can throw exception
		- if call 2nd times (or more), return result directly (Not compute again)
	- FutureTask implement Runnable
	- FutureTask can be constructed with Callable

- ThreadPool

5) Queue

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/block_queue_method.png"></p>

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/block_queue.png"></p>

- [code demo](https://github.com/yennanliu/JavaHelloWorld/blob/main/dev_projects/multithreading/Multithreading/src/main/java/com/yen/atguigu/queue/course35/BlockingQueueDemo.java)


6) Thread pool

- Maintain several threads, make sure resorces is managed.
	- reduce resource cost
	- better performance (no need to wait new thread creatation)
- Threads are waiting in queue to be assigned, used. Once thread usage is finish, it will be PUT BACK to the pool, so can be used by other task
- Similar to DB connection pool
- newSingleThreadExecutor, newFixedThreadPool, newCachedThreadPool are ALL using `ThreadPool` under the hood

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_pool_class.png"></p>

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_pool_class_2.png"></p>

- [code demo](https://github.com/yennanliu/JavaHelloWorld/tree/main/dev_projects/multithreading/Multithreading/src/main/java/com/yen/atguigu/pool/course37)

- ThreadPoolExecutor parameters :

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/ThreadPoolExecutor_param.png"></p>

- ONLY when execute() is executed, then thread is created (e.g. : cachedThreadPool.execute)

- ThreadPool internal structure

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_pool_internal.png"></p>

- RejectPolicy

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_abort_policy.png"></p>


7) Fork/join

- Break down a complex task to small sub tasks, run separately, then join results to final output

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/fork_join_1.png"></p>

<p ><img src ="https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/fork_join_2.png"></p>


## Ref

- https://github.com/callicoder/java-concurrency-examples
- https://github.com/code-review-checklists/java-concurrency

- https://github.com/PacktPublishing/Java-Concurrency-Multithreading-in-Practice/tree/master
- https://jcip.net/
- https://jcip.net/listings.html

- Concurrent bank

	- https://github.com/AndreiLoyevets/concurrency-lab/tree/master/src/com/epam/andrii_loievets/concurrency/bank
	- https://www.geeksforgeeks.org/banking-transaction-system-using-java/
	- https://home.csulb.edu/~pnguyen/cecs277/lecnotes/ch21Thread.pdf
	- https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools


- Note
	- Synchronized + Runnable example
	- https://hackmd.io/@no4sms04/H10xNAs7q