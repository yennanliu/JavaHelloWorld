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

- Mockito
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

## Ref

- TDD book
	- https://github.com/yennanliu/knowledge_base_repo/blob/master/book/java/Java%E6%B5%8B%E8%AF%95%E9%A9%B1%E5%8A%A8%E5%BC%80%E5%8F%91.pdf - book
	- https://bitbucket.org/vfarcic/workspace/projects/PROJ - code

- Other code
	- https://github.com/in28minutes/spring-boot-master-class


- Other video
	- https://www.youtube.com/watch?v=eMU_hninZAs&list=PLukoBpjuyzMOPIBU8mlpkeF819h2e0dqn
	- https://www.youtube.com/watch?v=z6gOPonp2t0