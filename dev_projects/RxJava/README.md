# RX Java

## Concept

- Observable type
	- https://youtu.be/l4zfIkRsT_8?si=7O7qBEwWrwGd4qnn&t=345
<p><img src ="./doc/pic/rx_java_can_onserver.png" ></p>

- Schedulers
	- https://youtu.be/4menosDtstk?si=e6JB22qoqaSwXFQa&t=440
<p><img src ="./doc/pic/schedulers.png" ></p>

- just
	- just()：建立Flux序列，並聲明指定資料流

- subscribe
	- 訂閱Flux序列，只有進行訂閱後才回觸發資料流，不訂閱就什麼都不會發生

- Mono VS Flux

	- Flux 類似 RxJava 的 Observable，它可以觸發零到多個事件，並根據實際情況結束處理或觸發錯誤。
	<p><img src ="./doc/pic/flux.png" ></p>


	- Mono 最多只觸發一個事件，所以可以把 Mono 用於在非同步任務完成時發出通知。
	<p><img src ="./doc/pic/mono.png" ></p>

	- Flux 和Mono 都是資料流的發布者，使用Flux 和Mono 都可以發出三種資料訊號：元素值，錯誤訊號，完成訊號；錯誤訊號和完成訊號都代表終止訊號，終止訊號用於告訴訂閱者資料流結束了，錯誤訊號終止資料流同時把錯誤訊息傳遞給訂閱者。
	- https://www.cnblogs.com/crazymakercircle/p/16127013.html

	- 


## Ref
- video
	- https://www.youtube.com/watch?v=7mbjhNCWqvs&list=PLZ3FH0lcV0117kiek3g-qiQDkO4ezy_Ro
	- https://www.youtube.com/watch?v=EExlnnq5Grs&list=PLqq-6Pq4lTTYPR2oH7kgElMYZhJd4vOGI
- code
	- tutorial
	   	- https://github.com/taku-k/rx-spring-boot-react-starter
	   	- https://github.com/mrroin/Mrroin_Base_Backend_Java_Rx/tree/main
	   	- https://github.com/koushikkothagal/reactive-java-workshop
  	- project
  		- https://github.com/ojacquemart/spring-boot-rxjava/tree/master
  		- https://github.com/ravindraranwala/SpringBootRxJava
