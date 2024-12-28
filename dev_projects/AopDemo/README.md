# AOP (Aspect Orient Programming) Demo

> AOP(Aspect Orient Programming)，主要以proxy pattern將商業邏輯與業務邏輯分開，讓開發者更聚焦商業邏輯


AOP（Aspect Oriented Programming，面向切面編程）是一種設計思想，是軟件設計領域中的面向切面編程。它是面向對象編程的一種補充和完善，它通過預編譯方式和運行期動態代理方式實現，在不修改源代碼的情況下，給程式動態統一添加額外功能的一種技術。利用 AOP 可以對業務邏輯的各個部分進行隔離，從而使得業務邏輯各部分之間的耦合度降低，提高程式的可重用性，同時提升了開發的效率。


@Aspec : 用於標記切面類別。
@Pointcut : 標記切入點。
@Before : 在切入點開始處執行。
@After : 在切入點結尾處執行。
@AfterReturning : 在切入點傳回(return)內容後執行，用於對傳回內容進行一些加工處理。
@Around : 在切入點前後執行，並可控制何時執行切入點本身的內容。
@AfterThrowing : 當切入點拋出例外後執行。

## Concept

- 靜態代理:
	- https://youtu.be/gVpjE2dYD3w?si=C58N0pYmq0FI1HzG&t=256
	- https://github.com/yennanliu/JavaHelloWorld/tree/main/dev_projects/AopDemo/src/main/java/org/example/StaticProxy

- 動態代理:
	- https://youtu.be/pjGu5Y8e2vU?si=MUW7sIWMNfssyhWH
	- https://github.com/yennanliu/JavaHelloWorld/tree/main/dev_projects/AopDemo/src/main/java/org/example/DynamicProxy
	- Types
		- https://youtu.be/DMGd5egBl00?si=n68tbwFP-LMVaIv6&t=47
		- type 1) JDK 動態代理
			- 代理對象`有接口`(interface)
			- 生成接口實現類的代理對象
			- 代理對象, 目標對象都實現相同接口
		- type 2) cglib 動態代理
			- 代理對象沒有接口(interface)
			- 通過`繼承`被代理的目標類
			- 不需要目標類實現接口

## Ref
- https://youtu.be/U40ZiGNKmiI?si=FsOigwm9KeyqLvaT
- https://tech-blog.cymetrics.io/posts/maxchiu/aop/
- https://ithelp.ithome.com.tw/articles/10329009