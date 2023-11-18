# TDD dev Projects

## Quick start

## Step

- Write a test
- run all tests
- complete main code
- run all tests
- refactor
- repeat above ...
- run all tests

## Concepts

- Mockito terms
  - 啞元物件（dummy object）用於替換真正的方法參數
  - 測試存根（test stub）用於將實際物件替換為測試特定對象，以便向受測系統提供所需的間接輸入
  - 測試間諜（test spy）記錄受測系統（SUT）向另一個元件發出的間接輸出調用，讓測試隨後能夠進行驗證；
  - 模擬對象（mock object）用於將受測系統所依賴的對象替換為測試特定對象，以驗證SUT是否正確使用；
  - 偽造物件（fake object）用於將受測系統所依賴的元件替換為量級更輕的實作。

- Mockito API
- mock()：用於建立模擬對象，也可使用when()和given()指定這些模擬對象的行為。
- spy()：
  - 可用來實現部分模擬。 除非另有說明，否則間諜物件呼叫實際方法。 與模擬物件 一樣，對於間諜物件的每個公有或受保護的方法（靜態方法除外），都可設定其行為。
  - 主要差異在 mock()創建一個完全偽造的對象，而spy()使用實際對象。
- verify()：用於檢查呼叫方法時提供的是否為指定參數，這是一種斷言。

JUnit API
- @BeforeClass: 在類別被載入前（第一個測試方法運行前）執行與它相關聯的方法
- @Before : 在每個測試運行前執行與它相關聯的方法。 這兩個註解用來測試存在前置條件的情形
  最常見的例子是在資料庫（很可能位於記憶體）中設定測試資料
- 與這兩個註解對應的是@After和@AfterClass，它們的主要用途是銷毀設定階段或其他測試創建的資料或狀
  態。 每個測試都應獨立於其他測試，另外，任何測試都不應受其他測試的影響。拆除階段有助於確保系統就像未執行任何測試一樣。

## Ref

- TDD book
	- https://github.com/yennanliu/knowledge_base_repo/blob/master/book/java/Java%E6%B5%8B%E8%AF%95%E9%A9%B1%E5%8A%A8%E5%BC%80%E5%8F%91.pdf - book
	- https://bitbucket.org/vfarcic/workspace/projects/PROJ - code

- Other code
	- https://github.com/in28minutes/spring-boot-master-class


- Other video
    - https://www.youtube.com/watch?v=eMU_hninZAs&list=PLukoBpjuyzMOPIBU8mlpkeF819h2e0dqn
    - https://www.youtube.com/watch?v=z6gOPonp2t0

- Other projects
  - URL Shortener
  
    - https://medium.com/geekculture/create-your-own-url-shorteners-with-spring-boot-redis-289c9000f747
    - https://github.com/abinator-1308/urlshortener
  
    - https://www.youtube.com/watch?v=qfkFhcxd2XI - video
    - https://github.com/arocks/tiny - py code

    - https://www.youtube.com/watch?v=xlFvb-3CbsE - video
    - https://github.com/talk2amareswaran/Building-a-Simple-URL-Shortener-with-Spring-Boot - java code
    - https://github.com/zeeshaanahmad/url-shortener/tree/master - java code